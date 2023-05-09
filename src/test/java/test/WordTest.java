package test;

import org.junit.Test;
import week4.day5.ReadWordUtils;
import week4.day6.WriteWordUtils;

import java.io.IOException;

public class WordTest {
    @Test
    public void readDocx(){
        String path = "C:\\Users\\联想\\Desktop\\小游戏代码.docx";
        String docx = ReadWordUtils.readWord(path);
        System.out.println(docx);
    }

    @Test
    public void readDoc(){
        String path = "C:\\Users\\联想\\Desktop\\测试.doc";
        String doc = ReadWordUtils.readWord(path);
        System.out.println(doc);
    }

    @Test
    public void writeWord(){
        String path = "E:\\java学习\\测试.docx";
        String text = "你好word";
        WriteWordUtils.writeWord(path,text);
    }
}
