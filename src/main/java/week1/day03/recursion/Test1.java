package week1.day03.recursion;

public class Test1 {
    public static void main(String[] args) {
        int num = 5;
        int fruit = recursion(5);
        System.out.println(num+"*"+(num-1)+"*……*1="+fruit);
    }

    public static int recursion(int num){
        int fate = num;
        if(num==1){
            return 1;
        }else {
            return fate*recursion(fate-1);
        }
    }
}
