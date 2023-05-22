package week5.day5;

import org.springframework.util.ClassUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author LuoXuanwei
 * @date 2023/5/22 13:06
 */
public class RunPy {
    public static void main(String[] args) {
        jscienceTest("K_means4.py");
    }

    /**
     * java调用python结果，并获得python的返回值
     */
    private static void jscienceTest(String fileName) {
        float[] data = new float[]{55.2f, 57.266666666666666f, 63.1f, 58.61538461538461f, 56.6f, 56.13333333333333f, 54.5f,
                55.096774193548384f, 52.666666666666664f, 54.5f, 55.46153846153846f, 55.583333333333336f, 57.857142857142854f,
                58.0f, 68.0f, 58.6f, 57.0f, 54.15384615384615f, 58.5f, 55.0f, 54.8421052631579f, 55.111111111111114f, 55.0f, 54.0f,
                52.55555555555556f, 52.8f, 51.666666666666664f, 49.285714285714285f, 49.44444444444444f, 52.0f, 49.375f,
                52.44444444444444f, 56.142857142857146f, 58.0f, 55.166666666666664f, 56.0f, 57.5f, 56.0f, 53.5f,
                54.166666666666664f, 53.875f, 51.2f, 52.5f, 59.25f, 57.0f, 56.1f, 75.11111111111111f, 68.55555555555556f,
                73.6923076923077f, 79.66666666666667f, 74.0f, 76.625f, 66.23529411764706f, 71.8f, 73.6f, 65.48275862068965f,
                58.0f, 53.0f, 51.166666666666664f, 49.166666666666664f, 52.0f, 50.36363636363637f, 54.77777777777778f, 54.5f,
                55.38461538461539f, 54.333333333333336f, 58.5f, 51.62068965517241f, 49.4f, 50.666666666666664f, 57.92f,
                56.0f, 54.45454545454545f, 55.0f, 60.55555555555556f, 63.875f, 64.8f, 73.0f, 73.1f, 76.0f, 76.44444444444444f,
                71.0f, 63.0188679245283f, 57.142857142857146f, 58.0f, 57.9375f, 52.294117647058826f, 55.45f,
                55.285714285714285f, 53.857142857142854f, 53.0f, 53.8235294117647f};

        // 获取python文件所在目录地址
        String windowsPath = ClassUtils.getDefaultClassLoader().getResource("").getPath().substring(1) + "py/";

        String pythonPath = windowsPath + fileName;
        //指定命令、路径、传递的参数
        String[] arguments = new String[]{"python", pythonPath, Arrays.toString(data), String.valueOf(15), String.valueOf(2)};
        StringBuilder sbrs = null;
        StringBuilder sberror = null;
        try {
            ProcessBuilder builder = new ProcessBuilder(arguments);
            Process process = builder.start();
            //获取字符输入流对象
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));
            //获取错误信息的字符输入流对象
            BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream(), "utf-8"));
            String line = null;
            sbrs = new StringBuilder();
            sberror = new StringBuilder();
            //记录输出结果
            while ((line = in.readLine()) != null) {
                sbrs.append(line);
            }
            //记录错误信息
            while ((line = error.readLine()) != null) {
                sberror.append(line);
            }
            in.close();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(sbrs);
        System.out.println(sberror);
    }
}
