package week9.day3;

import week9.day3.factory.DatabaseLoggerFactory;
import week9.day3.factory.FileLoggerFactory;
import week9.day3.factory.LoggerFactory;
import week9.day3.logger.Logger;
import week9.day3.util.XMLUtil;

/**
 * @author LuoXuanwei
 * @date 2023/9/27 19:11
 */
public class Client {
    public static void main(String[] args) {
        /*LoggerFactory loggerFactory1 = new DatabaseLoggerFactory();
        Logger logger1 = loggerFactory1.createLogger();
        logger1.writeLog();
        System.out.println("========================================");
        LoggerFactory loggerFactory2 = new FileLoggerFactory();
        Logger logger2 = loggerFactory2.createLogger();
        logger2.writeLog();*/
        LoggerFactory factory = (LoggerFactory) XMLUtil.getBean();
        factory.writeLog();
    }
}
