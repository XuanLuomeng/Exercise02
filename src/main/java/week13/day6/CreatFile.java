package week13.day6;

import java.io.IOException;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2025/3/12 00:18
 */
public class CreatFile {
    // 手动创建一个名为fraud_data.txt的文件位于当前目录下
    public static void main(String[] args) throws IOException {
        try {
            // 创建一个名为fraud_data.txt的文件
            java.io.File file = new java.io.File("fraud_data.txt");

            // 创建一个文件输出流，用于写入数据
            java.io.FileOutputStream fos = new java.io.FileOutputStream(file);

            // 写入一些测试数据
            String data = "This is some test data.";
            fos.write(data.getBytes());

            // 关闭文件输出流
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
