package com.yd.yx.common.thread;

import com.yd.yx.common.constant.CommonConstant;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @ClassName
 * @Description:
 * @Author:
 * @Date:
 **/
@EnableAsync
@Configuration
public class AsyncConfiguration implements AsyncConfigurer {

    private static final String TASK_EXECUTOR_NAME_PREFIX_DEFAULT = "taskExecutor-";
    private static final String TASK_EXECUTOR_NAME_PREFIX_SERVICE = "serviceTaskExecutor-";
    private static final String TASK_EXECUTOR_NAME_PREFIX_IO = "ioTaskExecutor-";

    @Value("${thread.pool.size.core}")
    private Integer corePoolSize;

    @Value("${thread.pool.size.max}")
    private Integer maxPoolSize;

    @Value("${thread.pool.queue.capacity}")
    private Integer queueCapacity;

    @Override
    @Bean
    @Qualifier(value = CommonConstant.TASK_EXECUTOR_DEFAULT)
    public Executor getAsyncExecutor() {
        return newTaskExecutor(TASK_EXECUTOR_NAME_PREFIX_DEFAULT);
    }

    @Bean
    @Qualifier(value = CommonConstant.TASK_EXECUTOR_SERVICE)
    public Executor getServiceAsyncExecutor() {
        return newTaskExecutor(TASK_EXECUTOR_NAME_PREFIX_SERVICE);
    }

    @Bean
    @Qualifier(value = CommonConstant.TASK_EXECUTOR_IO)
    public Executor getIoAsyncExecutor() {
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(TASK_EXECUTOR_NAME_PREFIX_IO);
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }

    private Executor newTaskExecutor(final String taskExecutorNamePrefix) {
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(taskExecutorNamePrefix);
        return executor;
    }
}
