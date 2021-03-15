package com.yd.yx.common.log.controller;

import java.text.MessageFormat;
import javax.servlet.http.HttpServletRequest;

import com.yd.yx.common.constant.CommonConstant;
import com.yd.yx.common.constant.ResponseStatusEnum;
import com.yd.yx.common.exception.BaseException;
import com.yd.yx.common.exception.CommonException;
import com.yd.yx.common.utils.ErrorMsgUtils;
import com.yd.yx.common.utils.ResultUtil;
import com.yd.yx.common.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName
 * @Description:
 * @Author:
 * @Date:
 **/
@RestControllerAdvice
@Slf4j
public class ControllerExceptionAspect {

    @Autowired
    HttpServletRequest request;

    @ExceptionHandler(Exception.class)
    // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO handlerException(Exception e) {
        if (e instanceof BaseException) {
            BaseException commonException = (BaseException) e;

            String locale = StringUtils.isNotBlank(request.getHeader("language")) ? request.getHeader("language") : "zh-CN";
            String msg = ErrorMsgUtils.getErrorMsg(commonException.getCode(), locale);
            String msgPattern = StringUtils.isNotBlank(msg) ? msg : e.getMessage();
            String userMsg = MessageFormat.format(msgPattern, commonException.getValues());
            return ResultUtil.error(ResponseStatusEnum.FAIL.getCode(), commonException.getCode(), userMsg);
        }
        return ResultUtil.error(ResponseStatusEnum.FAIL.getCode(), "", "UNKNOW SYSTEM ERROR!!!");
    }
}