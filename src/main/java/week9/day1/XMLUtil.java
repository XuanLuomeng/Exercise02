package week9.day1;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @author LuoXuanwei
 * @date 2023/9/13 19:23
 */
public class XMLUtil {
    //该方法用于从xml配置文件中提取图表类型，并返回类型名
    public static String getChartType(){
        try{
            //创建文档对象
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document;
            document = builder.parse(new File("src/main/resources/conf/config.xml"));

            //获取包含表类型的文本结点
            NodeList chartTypeName = document.getElementsByTagName("chartType");
            Node classNode = chartTypeName.item(0).getFirstChild();
            String chartType = classNode.getNodeValue().trim();
            return chartType;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
