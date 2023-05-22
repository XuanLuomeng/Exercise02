package week5.day3;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Ja {
    static Logger logger = LoggerFactory.getLogger(Ja.class);

    /**
     * 执行python脚本
     *
     * @param fileName 脚本文件名称
     * @param params   脚本参数
     * @throws IOException
     */
    public void execPythonFile(String fileName, String params) throws IOException {
        // 获取python文件所在目录地址
        String windowsPath = ClassUtils.getDefaultClassLoader().getResource("").getPath().substring(1) + "py/";

        // windows执行脚本需要使用 cmd.exe /c 才能正确执行脚本
        Process process = new ProcessBuilder("cmd.exe", "/c", "python", windowsPath + fileName, params).start();

        logger.info("读取python文件 开始 fileName={}", fileName);
        BufferedReader errorReader = null;
        // 脚本执行异常时的输出信息
        errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        List<String> errorString = read(fileName, errorReader);
        logger.info("读取python文件 异常 fileName={}&errorString={}", fileName, errorString);

        // 脚本执行正常时的输出信息
        BufferedReader inputReader = null;
        inputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        List<String> returnString = read(fileName, inputReader);
        logger.info("读取python文件 fileName={}&returnString={}", fileName, returnString);

        try {
            logger.info("读取python文件 wait fileName={}", fileName);
            process.waitFor();
        } catch (InterruptedException e) {
            logger.error("读取python文件 fileName=" + fileName + " 等待结果返回异常", e);
        }
        logger.info("读取python文件 fileName={} == 结束 ==", fileName);
        String f="C:\\Users\\20356\\myTree";
        String g="D:\\jnote\\test.png";
    }

    private List<String> read(String fileName, BufferedReader reader) {
        List<String> resultList = Lists.newArrayList();
        String res = "";
        while (true) {
            try {
                if (!((res = reader.readLine()) != null)) {
                    break;
                }
            } catch (IOException e) {
                logger.error("读取python文件 fileName=" + fileName + " 读取结果异常", e);
            }
            resultList.add(res);
        }
        return resultList;
    }
}
