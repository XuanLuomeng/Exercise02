package test;

import org.junit.Test;
import week4.day7.PDFUtils;

public class PDFTest {
    @Test
    public void writePDF() {
        String path = "E:\\学习文档\\";
        String fileName = "测试.pdf";
        String text = "你好！";
        PDFUtils.writePdf(path, fileName, text);
    }
}
