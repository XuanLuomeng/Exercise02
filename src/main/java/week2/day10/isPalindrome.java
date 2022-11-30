package week2.day10;

public class isPalindrome {
    //Way1
    public static boolean isPalin1(String str) {
        Stack<Character> st = new Stack();
        int n = str.length();
        int index = 0;
        while (index < n / 2) {
            st.push(str.charAt(index));
            index++;
        }
        if (n % 2 == 1) {
            index++;
        }
        while (index < n) {
            if (st.pop() != str.charAt(index)) {
                return false;
            }
            index++;
        }
        return true;
    }

    //Way2
    public static boolean isPalin2(String str) {
        StringBuilder s1 = new StringBuilder(str);
        int index = 0;
        int count = 0;//insert
        while (index <= str.length()) {
            s1.insert(count, '$');
            index++;
            count += 2;
        }
        str = s1.toString();
        System.out.println(str);
        Stack<Character> st = new Stack();
        int n = str.length();
        index = 0;
        while (index < n / 2) {
            st.push(str.charAt(index));
            index++;
        }
        index++;
        while (index < n) {
            if (st.pop() != str.charAt(index)) {
                return false;
            }
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "abcdcba";
        if (isPalin2(str)) {
            System.out.println("是回文串");
        } else {
            System.out.println("不是回文串");
        }
    }

}
