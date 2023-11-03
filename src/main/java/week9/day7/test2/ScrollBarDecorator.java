package week9.day7.test2;

/**
 * @author LuoXuanwei
 * @date 2023/11/1 21:17
 */
public class ScrollBarDecorator extends ComponentDecorator{
    public ScrollBarDecorator(Component component) {
        super(component);
    }

    @Override
    public void display(){
        this.setScrollBar();
        super.display();
    }

    public void setScrollBar(){
        System.out.println("+滚动条");
    }
}
