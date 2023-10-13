package week9.day2;

/**
 * @author LuoXuanwei
 * @date 2023/9/20 19:16
 */
public class StudentDiscount extends Discount {
    @Override
    public double calculate(double price) {
        return 0.8 * price;
    }
}
