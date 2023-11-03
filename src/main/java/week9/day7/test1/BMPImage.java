package week9.day7.test1;

/**
 * @author LuoXuanwei
 * @date 2023/11/1 20:49
 */
public class BMPImage extends Image{
    @Override
    void parseFile(String fileName) {
        Matrix matrix = new Matrix();
        imageImp.doPaint(matrix);
        System.out.println(fileName + "格式为:BMP");
    }
}
