package week5.day5;

import org.springframework.util.ClassUtils;

/**
 * @author LuoXuanwei
 * @date 2023/5/22 22:44
 */
public class Test {
    public static void main(String[] args) {
        RunPy py = new RunPy();

        // 获取python文件所在目录地址
        String windowsPath = ClassUtils.getDefaultClassLoader().getResource("").getPath().substring(1) + "py/";
        String pythonPath = windowsPath + "Untitled7.py";
        //指定命令、路径、传递的参数
        //'sepal_length','sepal_width','petal_length','class','SETOSA','VERSICOLOR','sada'
        String[] arguments = new String[]{"python", pythonPath,
                "E:\\python\\",
                "E:\\学习文档\\iris.xlsx",
                String.valueOf(1),
                "sepal_length",
                "sepal_width",
                "petal_length",
                "class",
                "SETOSA",
                "VERSICOLOR",
                "sada"};
        py.jscienceTest(arguments);
    }
}
