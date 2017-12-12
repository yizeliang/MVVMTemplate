package cn.yzl.library.util;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池工具
 * Created by YZL on 2017/11/13.
 */
public class ThreadExcutorUtils {
    public static Executor NORMAL_THREAD_EXCUTOR;

    private ThreadExcutorUtils() {
    }

    /**
     * 获取线程池
     *
     * @return
     */
    public static Executor getNormalThreadExcutor() {
        if (NORMAL_THREAD_EXCUTOR == null) {
            synchronized (ThreadExcutorUtils.class) {
                if (NORMAL_THREAD_EXCUTOR == null) {
                    NORMAL_THREAD_EXCUTOR = new ThreadPoolExecutor(0, 10,
                            120L, TimeUnit.SECONDS,
                            new SynchronousQueue<Runnable>());
                }
            }
        }
        return NORMAL_THREAD_EXCUTOR;
    }

    /**
     * 获取一个计时器服务
     *
     * @param poolSize
     * @return
     */
    public ScheduledExecutorService createScheduledExecutorService(int poolSize) {
        return new ScheduledThreadPoolExecutor(poolSize);
    }
}
