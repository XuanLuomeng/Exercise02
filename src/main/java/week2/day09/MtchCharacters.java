package week2.day09;

import java.util.ArrayList;
import java.util.HashMap;

public class MtchCharacters {
    public ArrayList<String> arrayList = new ArrayList<>();
    public HashMap<String, String> hashMap = new HashMap<>();

    public static void main(String[] args) {
        //Build a dictionary
        MtchCharacters match = new MtchCharacters();
        match.hashMap.put("{", "}");
        match.hashMap.put("(", ")");
        match.hashMap.put("[", "]");
        String[] str = {"{", "(", "[", "("};
        for (int len = 0; len < str.length; len++) {
            match.arrayList.add(str[len]);
        }
        String[] stri = {")", "]", ")", "}"};
        for (int len = 0; len < stri.length; len++) {
            boolean push = match.push(stri[len]);
            if (push == false) {
                break;
            }
        }
        if (match.arrayList.size() == 0) {
            System.out.println("匹配成功");
        }else {
            System.out.println("符号不匹配");
        }
    }

    public void add(String str) {
        arrayList.add(str);
    }

    public boolean push(String str) {
        //get compareString by dictionary
        String s = arrayList.get(arrayList.size() - 1);
        String st = hashMap.get(s);
        if (st.equals(str)) {
            arrayList.remove(arrayList.size() - 1);
            return true;
        } else {
            return false;
        }
    }
}
