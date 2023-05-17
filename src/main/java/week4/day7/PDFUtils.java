package week4.day7;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PDFUtils {
    public static void writePdf(String path, String fileName, String text) {
        try {
            //创建文档对象
            Document document = new Document();
            //设置输出流
            PdfWriter.getInstance(document, new FileOutputStream(path + fileName));
            //打开文档
            document.open();
            //向文档中添加内容
            document.add(new Paragraph(new Chunk(text)));
            //关闭文档
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}