package com.renova.zhihudailylab.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池，最大5个，核心1个
 * Created by Renova on 2015/10/29.
 */
public class ThreadExecutor {

    private static final int CORE_POOL_SIZE = 1;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>();

    private final ThreadPoolExecutor threadPoolExecutor;

    private static ThreadExecutor instance;

    static {
        instance = new ThreadExecutor();
    }

    private ThreadExecutor() {
        threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME,
                TIME_UNIT, WORK_QUEUE);

    }

    public static ThreadExecutor getInstance() {
        return instance;
    }

    public void execute(Runnable runnable) {
        if (runnable != null) {
            threadPoolExecutor.execute(runnable);
            threadPoolExecutor.getQueue();
        }
    }
}
