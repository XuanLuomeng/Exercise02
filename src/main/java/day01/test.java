package day01;

public class test {
    public static void main(String[] args) {
        String s = "";
        String[] st = s.split(",");
        System.out.println(st.length);

        String a = ",";
        st = a.split(",");
        System.out.println(st.length);

        String b = "2,3,";
        st = b.split(",");
        System.out.println(st.length);

        String c = "2,";
        st = c.split(",");
        System.out.println(st.length);
    }
}
