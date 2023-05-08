package week4.day5;

import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.extractor.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadDocUtils {
    public static String ReadDoc(String path)throws IOException{
        String result = "";
        try{
            if(path.endsWith(".doc")){
                InputStream is = new FileInputStream(path);
                
                result = ;
            }else if (path.endsWith(".docx")){
                OPCPackage opcPackage = POIXMLDocument.openPackage(path);
                POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
                result = extractor.getText();
                extractor.close();
            }else {
                System.out.println("此文件不是word文档");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
