package week13.day6;

import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2025/3/12 00:16
 */
public class FraudDetector {
    public static void main(String[] args) throws IOException {
        // 1. 加载模型
        try (InputStream modelIn = new FileInputStream("fraud-detector.bin")) {
            DoccatModel model = new DoccatModel(modelIn);
            DocumentCategorizerME categorizer = new DocumentCategorizerME(model);

            // 2. 待检测文本
            String text = "家里有急事，你快回来";

            // 3. 分类预测
            double[] outcomes = categorizer.categorize(text.split(" "));
            String category = categorizer.getBestCategory(outcomes);

            // 4. 输出结果
            System.out.println("分类结果: " + category);
            System.out.println("诈骗概率: " + outcomes[categorizer.getIndex(category)]);
        }
    }
}
