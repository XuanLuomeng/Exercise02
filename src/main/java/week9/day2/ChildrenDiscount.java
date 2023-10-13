package week9.day2;

/**
 * @author LuoXuanwei
 * @date 2023/9/20 19:18
 */
public class ChildrenDiscount extends Discount {
    @Override
    public double calculate(double price) {
        if (price >= 20) {
            return price - 10;
        } else {
            return price;
        }
    }
}
