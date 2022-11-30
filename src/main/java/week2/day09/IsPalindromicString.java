package week2.day09;

import java.util.ArrayList;

public class IsPalindromicString {
    public ArrayList<String> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        IsPalindromicString string = new IsPalindromicString();
        String str = "123454321";
        String[] st = str.split("");
        for (int len = 0; len < st.length / 2; len++) {
            string.add(st[len]);
        }
        int le = 0;
        if (st.length % 2 != 0) {
            le = st.length / 2 + 1;
        } else {
            le = st.length / 2;
        }
        for (int len = le; len < st.length; len++) {
            boolean push = string.push(st[len]);
            if (push == false) {
                break;
            }
        }
        if (string.arrayList.size() != 0) {
            System.out.println("不是回文字");
        } else {
            System.out.println("是回文字");
        }
    }


    public void add(String str) {
        arrayList.add(str);
    }

    public boolean push(String str) {
        String st = arrayList.get(arrayList.size() - 1);
        if (st.equals(str)) {
            arrayList.remove(str);
            return true;
        } else {
            return false;
        }
    }
}
