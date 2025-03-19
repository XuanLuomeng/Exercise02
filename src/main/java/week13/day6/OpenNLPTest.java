package week13.day6;

import opennlp.tools.doccat.*;
import opennlp.tools.util.InsufficientTrainingDataException;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.TrainingParameters;

import java.io.*;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2025/3/12 00:16
 */
public class OpenNLPTest {
    public static void main(String[] args) throws IOException {
        // 1. 验证数据文件是否存在
        File dataFile = new File("fraud_data.txt");
        if (!dataFile.exists()) {
            throw new FileNotFoundException("训练数据文件不存在: " + dataFile.getAbsolutePath());
        }

        // 2. 加载数据并打印样本数
        InputStream dataIn = new FileInputStream(dataFile);
        ObjectStream<String> lineStream = new PlainTextByLineStream(() -> dataIn, "UTF-8");
        ObjectStream<DocumentSample> sampleStream = new DocumentSampleStream(lineStream);

        // 3. 调整训练参数（适用于小数据量）
        TrainingParameters params = new TrainingParameters();
        params.put(TrainingParameters.ITERATIONS_PARAM, "100");
        params.put(TrainingParameters.CUTOFF_PARAM, "0");
        params.put(TrainingParameters.ALGORITHM_PARAM, "MAXENT");

        // 4. 训练模型
        try {
            DoccatModel model = DocumentCategorizerME.train("en", sampleStream, params, new DoccatFactory());
            try (OutputStream modelOut = new BufferedOutputStream(new FileOutputStream("fraud-detector.bin"))) {
                model.serialize(modelOut);
                System.out.println("模型训练成功！");
            }
        } catch (InsufficientTrainingDataException e) {
            System.err.println("错误：训练数据仍不足，请确保每个类别至少有5条样本");
        } finally {
            sampleStream.close();
        }
    }
}
