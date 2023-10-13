package week9.day2;

/**
 * @author LuoXuanwei
 * @date 2023/9/20 19:32
 */
public class TicketFactory {
    public static Discount getDiscount(String type){
        if (type.equals("StudentDiscount")){
            return new StudentDiscount();
        }else if (type.equals("ChildrenDiscount")){
            return new ChildrenDiscount();
        }else if (type.equals("VIPDiscount")){
            return new VIPDiscount();
        }else {
            return new Discount();
        }
    }
}
