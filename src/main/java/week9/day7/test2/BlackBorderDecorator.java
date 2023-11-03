package week9.day7.test2;

/**
 * @author LuoXuanwei
 * @date 2023/11/1 21:18
 */
public class BlackBorderDecorator extends ComponentDecorator{
    public BlackBorderDecorator(Component component) {
        super(component);
    }

    @Override
    public void display(){
        this.setBlackBorder();
        super.display();
    }

    public void setBlackBorder(){
        System.out.println("+黑边框");
    }
}
