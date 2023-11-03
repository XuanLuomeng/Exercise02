package week9.day7.test1;

import javax.xml.parsers.*;

import org.w3c.dom.*;

import java.io.*;

/**
 * @author LuoXuanwei
 * @date 2023/11/1 20:51
 */
public class XMLUtil {
    public static Object getBean(String args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document;
            document = builder.parse(new File("src/main/resources/conf/config.xml"));
            NodeList nodeList = null;
            Node node = null;
            String name = null;
            nodeList = document.getElementsByTagName("className");
            if (args.equals("image")) {
                node = nodeList.item(0).getFirstChild();
            } else if (args.equals("windows")) {
                node = nodeList.item(1).getFirstChild();
            }
            name = node.getNodeValue();
            Class c = Class.forName(name);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
