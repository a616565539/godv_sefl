package com.godv.lgd.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: qt-core
 * @description: godv线程池
 * @author: GodV
 * @create: 2021-05-17 16:00
 **/
@Component
public class GodvThreadPool {

    private ThreadPoolExecutor threadPoolExecutor;

    /**
     * Constructor(构造方法) -> @Autowired(依赖注入) -> @PostConstruct(注释的方法)
     * bean初始化的实收执行方法
     */
    @PostConstruct
    public void init() {
        int availProcessors = Runtime.getRuntime().availableProcessors();
        threadPoolExecutor = new ThreadPoolExecutor(availProcessors, 2 * availProcessors + 1,
                60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1024 * 2),
                new ThreadFactoryBuilder().setNameFormat("global-thread-pool-%d").build());
    }

    @PreDestroy
    public void destroy() {
        threadPoolExecutor.shutdown();
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }
}
