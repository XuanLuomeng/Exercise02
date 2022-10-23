package day10;

public class Bracket {

    public static boolean isMatch(String str) {
        int index = 0;
        char e, x;
        Stack<Character> st = new Stack<Character>();
        while (index < str.length()) {
            e = str.charAt(index);
            if (e == '(' || e == '[' || e == '{') {
                st.push(e);
            } else {
                if (e == ')') {
                    if (st.empty()) {
                        return false;
                    }
                    char t = st.pop();
                    if (t != '(') {
                        return false;
                    }
                }
                if (e == ']') {
                    if (st.empty()) {
                        return false;
                    }
                    char t = st.pop();
                    if (t != '[') {
                        return false;
                    }
                }
                if (e == '}') {
                    if (st.empty()) {
                        return false;
                    }
                    char t = st.pop();
                    if (t != '{') {
                        return false;
                    }
                }
            }
            index++;
        }
        if (st.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "([])";
        if (isMatch(str)) {
            System.out.print("匹配");
        } else {
            System.out.println("不匹配");
        }
    }

}