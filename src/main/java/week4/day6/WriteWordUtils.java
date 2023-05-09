package week4.day6;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;

public class WriteWordUtils {
    public static void writeWord(String path, String text) {
        try {
            XWPFDocument document = new XWPFDocument();
            FileOutputStream out = new FileOutputStream(path);
            XWPFParagraph n = document.createParagraph();
            XWPFRun run = n.createRun();
            run.setText(text);
            document.write(out);
            document.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}