package test;

import junit.framework.TestCase;
import week10.day2.Triangle;

/**
 * @author LuoXuanwei
 * @date 2023/12/5 19:09
 */
public class TestTriangle extends TestCase {
    Triangle t1 = new Triangle(5, 2, 1);
    Triangle t2 = new Triangle(1, 5, 2);
    Triangle t3 = new Triangle(1, 2, 5);
    Triangle t4 = new Triangle(8, 8, 8);

    public void test() {
        assertEquals(0, t1.isTriangle());
        assertEquals(0, t2.isTriangle());
        assertEquals(1, t3.isTriangle());
        assertEquals(1, t4.isTriangle());
    }
}
