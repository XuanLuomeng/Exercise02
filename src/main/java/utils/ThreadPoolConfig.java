package utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/7/21 12:20
 *
 * jdk:17+
 *
 * application properties配置:
 *  thread.pool.corePoolSize = 16
 *  thread.pool.maxPoolSize = 32
 *  thread.pool.queueCapacity = 50
 *  thread.pool.keepAliveSeconds = 2
 */
@Configuration
public class ThreadPoolConfig {
    //线程池配置
    @Resource
    private ThreadPoolProperties threadPoolProperties;

    /*@Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        //核心线程数
        threadPoolProperties.setCorePoolSize(threadPoolProperties.getCorePoolSize());
        //最大可创建的线程数
        threadPoolProperties.setMaxPoolSize(threadPoolProperties.getMaxPoolSize());
        //等待队列最大长度
        threadPoolProperties.setQueueCapacity(threadPoolProperties.getQueueCapacity());
        //线程池维护线程所允许的空闲时间
        threadPoolProperties.setKeepAliveSeconds(threadPoolProperties.getKeepAliveSeconds());
        //异步方法内部线程名称
        threadPoolProperties.setThreadNamePrefix("spring默认线程-");
        //线程池对拒绝任务(无线程可用)的处理策略
        threadPoolProperties.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //任务都完成再关闭线程池
        threadPoolProperties.initialize();

        return threadPoolTaskExecutor;
    }*/
}
