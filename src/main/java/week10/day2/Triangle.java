package week10.day2;

/**
 * @author LuoXuanwei
 * @date 2023/12/5 19:06
 */
public class Triangle {
    private int a;
    private int b;
    private int c;

    public Triangle() {
    }

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int isTriangle() {
        if (a > b + c || b > a + c || c > a + b) {
            System.out.println(a + " " + b + " " + c + "不是三角形");
            return 0;
        } else {
            if (a == b || b == c || c == a) {
                if (a == b && c == b) {
                    System.out.println(a + " " + b + " " + c + "是等边三角形");
                    return 3;
                }
                System.out.println(a + " " + b + " " + c + "是等腰三角形");
                return 2;
            }
            System.out.println(a + " " + b + " " + c + "是不规则三角形");
            return 1;
        }
    }
}
