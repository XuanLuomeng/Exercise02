package week9.day3.factory;

import week9.day3.logger.DatabaseLogger;
import week9.day3.logger.Logger;

/**
 * @author LuoXuanwei
 * @date 2023/9/27 19:15
 */
public class DatabaseLoggerFactory extends LoggerFactory {
    @Override
    public void writeLog() {
        Logger logger = this.createLogger();
        logger.writeLog();
    }

    @Override
    public Logger createLogger() {
        return new DatabaseLogger();
    }
}
