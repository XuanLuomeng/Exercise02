package week2.day08.LinkedDemo;

import week2.day08.linkedListPojo.LinkListClass;

public class IncludeQuestion {
    public static void main(String[] args) {
        String str = "abcabcasdfxyzsdgsxhtrysdxxyyzazsthyrxxxyyzz";
        String[] strs = str.split("");
        LinkListClass<String> listClass = new LinkListClass<>(strs);
        int Bi = 0;
        for (int size = 0; size < listClass.getSize(); size++) {
            String st1 = listClass.getElem(size);
            if (st1.equals("x")) {
                if (size + 2 >= listClass.getSize()) {
                    continue;
                }
                String st2 = listClass.getElem(size + 1);
                String st3 = listClass.getElem(size + 2);
                String st = st1 + st2 + st3;
                if (st.equals("xyz") && Bi <= 1) {
                    Bi = 1;
                    continue;
                }
                if (size + 5 >= listClass.getSize()) {
                    continue;
                }
                String st4 = listClass.getElem(size + 3);
                String st5 = listClass.getElem(size + 4);
                String st6 = listClass.getElem(size + 5);
                st += st4 + st5 + st6;
                if (st.equals("xxyyzz") && Bi <= 2) {
                    Bi = 2;
                    continue;
                }
                if (size + 8 >= listClass.getSize()) {
                    continue;
                }
                String st7 = listClass.getElem(size + 6);
                String st8 = listClass.getElem(size + 7);
                String st9 = listClass.getElem(size + 8);
                st += st7 + st8 + st9;
                if (st.equals("xxxyyyzzz") && Bi <= 3) {
                    Bi = 3;
                    continue;
                }
            }
        }
        System.out.println("i=" + Bi);
    }
}