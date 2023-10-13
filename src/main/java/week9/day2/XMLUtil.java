package week9.day2;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @author LuoXuanwei
 * @date 2023/9/20 19:45
 */
public class XMLUtil {
    //该方法用于从xml配置文件中提取图表类型，并返回类型名
    public static String getTicketType(int id){
        try{
            //创建文档对象
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document;
            document = builder.parse(new File("src/main/resources/conf/config.xml"));

            //获取包含表类型的文本结点
            NodeList ticketTypeName = document.getElementsByTagName("ticketType");
            Node classNode = ticketTypeName.item(id).getFirstChild();
            String ticketType = classNode.getNodeValue().trim();
            return ticketType;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
