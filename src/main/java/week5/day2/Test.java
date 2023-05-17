package week5.day2;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Ja ja = new Ja();
        ja.execPythonFile("means.py"/*"K_means.py"*/,"");
    }
}