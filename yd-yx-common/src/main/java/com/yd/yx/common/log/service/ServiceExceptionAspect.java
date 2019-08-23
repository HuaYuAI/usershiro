package com.yd.yx.common.log.service;

import com.yd.yx.common.exception.CommonException;
import com.yd.yx.common.utils.CommonLogUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
/**
 * Created by huayu on 2019/8/22.
 */
@Aspect
@Component
@Slf4j
public class ServiceExceptionAspect {
    @Pointcut("@within(org.springframework.stereotype.Service) && execution(public * *(..))")
    private void servicePointcut() {}

    /**
     * 异常通知，用于拦截 Service 层记录异常日志
     */
    @AfterThrowing(pointcut = "servicePointcut()", throwing = "ex")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        String className = joinPoint.getTarget().getClass().getName();
        String method =  (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()");

        if (ex instanceof CommonException || ex.getCause() instanceof CommonException) {
            final CommonException cx = ex.getCause() instanceof CommonException ? (CommonException) ex.getCause() : (CommonException) ex;
            CommonLogUtil.printAndThrowErrorExceptionWithParams(log, className, method, cx.getCode(), ex.getMessage(), cx, cx.getValues());
        }
        // todo
        CommonLogUtil.printAndThrowErrorException(log, className, method, "ErrorCodeConstant.UNKNOWN_ERROR", ex.getMessage(), (Exception) ex);
    }
}
