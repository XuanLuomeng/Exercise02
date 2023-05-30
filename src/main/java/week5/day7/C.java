package week5.day7;

/**
 * @author LuoXuanwei
 * @date 2023/5/30 19:26
 */
class C {
    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        System.out.println(a.func1(100, 50) + "|" + b.func1(100, 50));
    }
}
