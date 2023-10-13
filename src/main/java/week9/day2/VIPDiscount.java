package week9.day2;

/**
 * @author LuoXuanwei
 * @date 2023/9/20 19:17
 */
public class VIPDiscount extends Discount {
    //用户积分,在此模拟积分累计,暂不考虑从数据库获取vip用户原积分值
    private double score;

    public void setScore(double score) {
        //模拟设置积分值
        this.score = score;
    }

    @Override
    public double calculate(double price) {
        //暂定模拟购票一次加10积分
        score += 10;
        //将积分存回数据库操作：略
        return 0.5 * price;
    }
}
