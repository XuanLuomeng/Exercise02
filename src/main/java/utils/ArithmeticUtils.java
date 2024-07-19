package utils;

import java.math.BigDecimal;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 用于高精确处理常用的数学运算
 * @date 2024/7/15 20:33
 */
public class ArithmeticUtils {
    //默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;

    /**
     * 提供精确的加法运算
     *
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static BigDecimal add(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.add(b2);
    }

    /**
     * 提供精确的加法运算
     *
     * @param value1 被加数
     * @param value2 加数
     * @param scale  保留scale位小数
     * @return 两个参数的和
     */
    public static BigDecimal add(String value1, String value2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.add(b2).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供精确的减法运算
     *
     * @param value1 被减数
     * @param value2 减数
     * @return 两个参数的差
     */
    public static BigDecimal sub(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.add(b2);
    }

    /**
     * 提供精确的减法运算
     *
     * @param value1 被减数
     * @param value2 减数
     * @param scale  保留scale位小数
     * @return 两个参数的差
     */
    public static BigDecimal sub(String value1, String value2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.subtract(b2).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供精确的乘法运算
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static BigDecimal mul(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.multiply(b2);
    }

    /**
     * 提供精确的乘法运算
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @param scale  保留scale位小数
     * @return 两个参数的积
     */
    public static BigDecimal mul(String value1, String value2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.multiply(b2).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供精确的除法运算
     *
     * @param value1 被除数
     * @param value2 除数
     * @return 两个参数的商
     */
    public static BigDecimal div(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.divide(b2);
    }

    /**
     * 提供精确的除法运算
     *
     * @param value1 被除数
     * @param value2 除数
     * @param scale  保留scale位小数
     * @return 两个参数的商
     */
    public static BigDecimal div(String value1, String value2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.divide(b2).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供精确的比较值
     *
     * @param value1
     * @param value2
     * @return 返回比较结果
     */
    public static Boolean compare(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.compareTo(b2) == 0 ? true : false;
    }

    /**
     * 提供精确的除余算法
     *
     * @param value1 被除数
     * @param value2 除数
     * @return 余数
     */
    public static BigDecimal remainderString(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.remainder(b2);
    }

    /**
     * 提供精确的除余算法
     *
     * @param value1 被除数
     * @param value2 除数
     * @param scale  保留scale位小数
     * @return 余数
     */
    public static BigDecimal remainderString(String value1, String value2, int scale) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.remainder(b2).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }
}
