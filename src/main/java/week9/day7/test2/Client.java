package week9.day7.test2;

/**
 * @author LuoXuanwei
 * @date 2023/11/1 21:19
 */
public class Client {
    public static void main(String[] args) {
        Component componentOne, componentTwo;
        componentOne = new Window();
        componentTwo = new ScrollBarDecorator(componentOne);
        componentTwo.display();
    }
}
