package test;

import org.junit.Test;
import week5.day2.Ja;

import java.io.IOException;

public class PythonTest {
    @Test
    public void pythonTest() throws IOException {
        Ja ja = new Ja();
        ja.execPythonFile("means.py","");
    }
}
