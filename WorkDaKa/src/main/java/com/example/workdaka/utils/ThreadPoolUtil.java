package com.example.workdaka.utils;

import java.util.concurrent.*;

/**
* java执行任务会创建新的线程，执行完之后会销毁线程，频繁的执行销毁会影响服务器性能，创建线程池重复利用已有的线程，加快程序运行，减少服务器消耗。
* 该线程池用于解决根据二维码、网址、解析内容查询产品信息的并发问题。
*/
public class ThreadPoolUtil {
    //创建线程池对象
    public ThreadPoolExecutor poolExecutor;

    //构造函数私有化，实现单例对象，保证程序中只有一个线程池，避免混乱。
    private ThreadPoolUtil() {
        /*完成线程池对象实例化，ThreadPoolExecutor参数如下：
         * corePoolSize:核心线程数，指定了线程池中的线程数量，它的数量决定了添加的任务是开辟新的线程去执行，还是放到workQueue任务队列中去；
         * maximumPoolSize:指定了线程池中的最大线程数量，这个参数会根据你使用的workQueue任务队列的类型，决定线程池会开辟的最大线程数量；
         * keepAliveTime:当线程池中空闲线程数量超过corePoolSize时，多余的线程会在多长时间内被销毁；
         * unit:keepAliveTime的单位
         * workQueue:任务队列，被添加到线程池中，但尚未被执行的任务；它一般分为直接提交队列、有界任务队列、无界任务队列、优先任务队列几种；
         * threadFactory:线程工厂，用于创建线程，一般用默认即可；
         * handler:拒绝策略；当任务太多来不及处理时，如何拒绝任务；
         */
        poolExecutor = new ThreadPoolExecutor(4, 10, 3, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(20),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
    }

    //静态内部类完成对象实例化。实现单例对象，保证程序中只有一个线程池，避免混乱。
    private static class PoolInner {
        private final static ThreadPoolUtil pool = new ThreadPoolUtil();
    }

    //获取唯一实例
    public static ThreadPoolUtil getInstance() {
        return PoolInner.pool;
    }

    //将任务扔到线程池里面去执行
    public static <T> Future<T> doJob(ThreadPoolExecutor threadPoolExecutor, Callable<T> callable) {
        return threadPoolExecutor.submit(callable);
    }

    //返回线程池执行任务的结果
    public static <T> T invertFuture(Future<T> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
