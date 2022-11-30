package week2.day10;

public class Onedata {
    public static char data[] = {'1', '2', '3', '4', '.', '5', '6', '7', '8'};
    public static double digital = 0;
    public static Stack<Integer> stack = new Stack();
    public static Queue<Integer> queue = new Queue();

    public static void push() {
        int index = 0;
        int sign = 0;
        for (; index < data.length; index++) {
            if (data[index] == '.') {
                sign = 1;
                continue;
            }
            if (sign == 0) {
                queue.push((int) data[index] - 48);
            } else {
                stack.push((int) data[index] - 48);    //char translate into int
            }
        }
    }

    public static double produce() {
        int index;
        while (!queue.empty()) {
            digital *= 10;
            digital += queue.pop();
            System.out.println(digital);
        }
        double di = 0;
        while (!stack.empty()) {
            di /= 10;
            di += stack.pop();
            System.out.println(di);
        }
        di /= 10;
        digital += di;
        return digital;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        push();
        System.out.print(produce());
    }
}
