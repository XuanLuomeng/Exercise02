package week5.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author LuoXuanwei
 * @date 2023/5/30 19:36
 */
public class Test7 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(6);
        list.add(0,4);
        list.remove(1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
