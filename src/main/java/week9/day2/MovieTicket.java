package week9.day2;

/**
 * @author LuoXuanwei
 * @date 2023/9/20 19:10
 */
public class MovieTicket {
    private double price;
    private Discount discount;

    public MovieTicket(){}

    public MovieTicket(String ticketType){
        this.discount = TicketFactory.getDiscount(ticketType);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return discount.calculate(this.price);
    }
}
