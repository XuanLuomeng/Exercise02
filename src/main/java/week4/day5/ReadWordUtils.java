package week4.day5;

import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.extractor.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.*;

public class ReadWordUtils {
    public static String readWord(String path){
        String result = "";
        try {
            if (path.endsWith(".doc")) {
                result = "此文件格式已不再支持，请转换使用docx文件";
            } else if (path.endsWith(".docx")) {
                OPCPackage opcPackage = POIXMLDocument.openPackage(path);
                POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
                result = extractor.getText();
                extractor.close();
            } else {
                System.out.println("此文件不是word文档");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
