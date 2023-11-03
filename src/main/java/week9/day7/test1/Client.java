package week9.day7.test1;

/**
 * @author LuoXuanwei
 * @date 2023/11/1 20:58
 */
public class Client {
    public static void main(String[] args) {
        Image image;
        ImageImp imageImp;
        image = (Image) XMLUtil.getBean("image");
        imageImp = (ImageImp) XMLUtil.getBean("windows");
        image.setImageImp(imageImp);
        image.parseFile("广东金融学院");
    }
}
