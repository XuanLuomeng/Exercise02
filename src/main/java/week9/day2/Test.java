package week9.day2;

/**
 * @author LuoXuanwei
 * @date 2023/9/20 19:23
 */
public class Test {
    public static final String STUDENT_TICKET = "StudentDiscount";
    public static final String CHILDREN_TICKET = "ChildrenDiscount";
    public static final String VIP_TICKET = "VIPDiscount";

    public static void main(String[] args) {
//        MovieTicket movieTicket = new MovieTicket();
//        movieTicket.setPrice(25);
//        movieTicket.setDiscount(new ChildrenDiscount());
//        double price = movieTicket.getPrice();
//        System.out.println("价格为:"+price);
//        MovieTicket movieTicket = new MovieTicket(STUDENT_TICKET);
//        movieTicket.setPrice(25);
//        double price = movieTicket.getPrice();
//        System.out.println("价格为:"+price);
        MovieTicket movieTicket = new MovieTicket(XMLUtil.getTicketType(2));
        movieTicket.setPrice(25);
        double price = movieTicket.getPrice();
        System.out.println("价格为:"+price);
    }
}
