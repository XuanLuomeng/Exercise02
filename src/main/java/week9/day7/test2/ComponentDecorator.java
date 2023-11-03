package week9.day7.test2;

/**
 * @author LuoXuanwei
 * @date 2023/11/1 21:16
 */
public class ComponentDecorator extends Component {
    private Component component;

    public ComponentDecorator(Component component) {
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }
}
