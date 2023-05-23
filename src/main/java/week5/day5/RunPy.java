package week5.day5;

import org.springframework.util.ClassUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author LuoXuanwei
 * @date 2023/5/22 13:06
 */
public class RunPy {

    /**
     * java调用python结果，并获得python的返回值
     */
    public void jscienceTest(String[] arguments) {
        try {
            ProcessBuilder builder = new ProcessBuilder(arguments);
            Process process = builder.start();
            //获取字符输入流对象
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));
            //获取错误信息的字符输入流对象
            BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream(), "utf-8"));
            String line = null;
            //记录输出结果
            line = in.readLine();
            System.out.println(line.split(" ")[1]);
            //记录错误信息
            while ((line = error.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
