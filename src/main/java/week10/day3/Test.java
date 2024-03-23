package week10.day3;

/**
 * @author LuoXuanwei
 * @date 2023/12/15 16:47
 */
public class Test {
    public static int function_1(int x, int y) {
        int z = 0;
        if ((x >= 1) && (y < 8)) {
            z = x + 1;
            System.out.print("no.1 if\t");
        }
        if ((x == 4) || (y > 5)) {
            z = x + y;
            System.out.print("no.2 if\t");
        }
        return z;
    }

    public static void main(String[] args) {
        /**
         * 从语句可以看出，不存在F*T*、*F*F组合
         */
        //语句覆盖
        System.out.println("no.1 test:\t");
        //T T
        System.out.println(function_1(4, 6));

        //判定覆盖
        System.out.println("no.2 test:\t");
        //F T
        System.out.println(function_1(0, 6));
        //T F
        System.out.println(function_1(2, 4));

        //条件覆盖
        System.out.println("no.3 test:\t");
        //T1 F2 T3 T4
        System.out.println(function_1(4, 9));
        //F1 T2 F3 F4
        System.out.println(function_1(0, 4));

        //条件组合覆盖
        System.out.println("no.4 test:\t");
        //T1 T2 T3 T4
        System.out.println(function_1(4, 6));
        //F1 T2 F3 T4
        System.out.println(function_1(0, 6));
        //T1 F2 T3 T4
        System.out.println(function_1(4, 9));
        //F1 F2 F3 T4
        System.out.println(function_1(0, 9));
        //T1 T2 T3 F4
        System.out.println(function_1(4, 4));
        //T1 T2 F3 F4
        System.out.println(function_1(1, 4));

        //判定条件覆盖
        System.out.println("no.5 test:\t");
        //T1 T2 F3 F4
        System.out.println(function_1(2, 4));
        //T1 F2 T3 T4
        System.out.println(function_1(4, 9));
        //F1 T2 F3 T4
        System.out.println(function_1(0, 7));
    }
}
