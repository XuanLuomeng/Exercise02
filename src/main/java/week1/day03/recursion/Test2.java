package week1.day03.recursion;

public class Test2 {
    public static void main(String[] args) {
        int num = 10;
        int furit = fabonacci(num);
        System.out.println("第"+num+"项为："+furit);
    }

    public static int fabonacci(int num){
        int sign = num;
        if (num==1){
            return 1;
        }else if(num==2){
            return 2;
        }else {
            return fabonacci(num-1)+fabonacci(num-2);
        }
    }
}
