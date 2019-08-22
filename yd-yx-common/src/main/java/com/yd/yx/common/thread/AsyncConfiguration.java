package com.yd.yx.common.thread;

/**
 * Created by huayu on 2019/8/22.
 */
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author 昱升
 * @date 2019/1/18 下午3:54
 */
@EnableAsync
@Configuration
public class AsyncConfiguration implements AsyncConfigurer {

    private static final String TASK_EXECUTOR_NAME_PREFIX_DEFAULT = "taskExecutor-";
    private static final String TASK_EXECUTOR_NAME_PREFIX_REPOSITORY = "repositoryTaskExecutor-";
    private static final String TASK_EXECUTOR_NAME_PREFIX_SERVICE = "serviceTaskExecutor-";
    private static final String TASK_EXECUTOR_NAME_PREFIX_IO = "ioTaskExecutor-";

    @Autowired
    DiamondContainer diamondContainer;

    @Override
    @Bean
    @Qualifier(value = CommonConstant.TASK_EXECUTOR_DEFAULT)
    public Executor getAsyncExecutor() {
        return newTaskExecutor(TASK_EXECUTOR_NAME_PREFIX_DEFAULT);
    }

    @Bean
    @Qualifier(value = CommonConstant.TASK_EXECUTOR_REPOSITORY)
    public Executor getRepositoryAsyncExecutor() {
        return newTaskExecutor(TASK_EXECUTOR_NAME_PREFIX_REPOSITORY);
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
        executor.setCorePoolSize(Integer.valueOf(diamondContainer.getValue(DiamondConstant.THREAD_POOL_CORE_SIZE_IO_KEY)));
        executor.setMaxPoolSize(Integer.valueOf(diamondContainer.getValue(DiamondConstant.THREAD_POOL_MAX_SIZE_IO_KEY)));
        executor.setQueueCapacity(Integer.valueOf(diamondContainer.getValue(DiamondConstant.THREAD_POOL_QUEUE_CAPACITY_IO_KEY)));
        executor.setThreadNamePrefix(TASK_EXECUTOR_NAME_PREFIX_IO);
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }

    private Executor newTaskExecutor(final String taskExecutorNamePrefix) {
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Integer.valueOf(diamondContainer.getValue(DiamondConstant.THREAD_POOL_CORE_SIZE_KEY)));
        executor.setMaxPoolSize(Integer.valueOf(diamondContainer.getValue(DiamondConstant.THREAD_POOL_MAX_SIZE_KEY)));
        executor.setQueueCapacity(Integer.valueOf(diamondContainer.getValue(DiamondConstant.THREAD_POOL_QUEUE_CAPACITY_KEY)));
        executor.setThreadNamePrefix(taskExecutorNamePrefix);
        return executor;
    }
}
