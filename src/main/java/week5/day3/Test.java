package week5.day3;

import java.io.IOException;

public class Test {

    private static String path = "";

    public static void main(String[] args) throws IOException {
        Ja ja = new Ja();
        ja.execPythonFile("K_means2.py", "");
    }
}
