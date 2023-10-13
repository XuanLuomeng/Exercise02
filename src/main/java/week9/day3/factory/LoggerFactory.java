package week9.day3.factory;

import week9.day3.logger.Logger;

/**
 * @author LuoXuanwei
 * @date 2023/9/27 19:11
 */
public abstract class LoggerFactory {
    public abstract void writeLog();

    public Logger createLogger(){
        return new Logger();
    }
}
