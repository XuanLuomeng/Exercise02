package utils;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/7/21 12:17
 */
@Data
@Configuration
//@ConfigurationProperties(prefix = "thread.pool")
public class ThreadPoolProperties {
    /**
     * 核心线程池大小
     */
    private int corePoolSize;

    /**
     * 最大可创建的线程数
     */
    private int maxPoolSize;

    /**
     * 队列最大长度
     */
    private int queueCapacity;

    /**
     * 线程池维护线程所允许的空闲时间
     */
    private int keepAliveSeconds;
}
