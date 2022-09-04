package day03.util;

import java.io.*;

public class ReadFile {
    public int[] read(String file, int num) throws IOException {
        String[] strArray;
        int[] array = new int[num];
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            strArray = line.split(",");
            for (int i = 0; i < num; i++) {
                array[i] = Integer.parseInt(strArray[i]);
            }
        }
        br.close();
        return array;
    }

    public int[] stream(String file, int num) throws IOException {
        InputStream fis = new FileInputStream(file);
        int[] array = new int[num];
        if (fis != null) {
            String[] strArray;
            String line = "";
            byte[] bys = new byte[1024];
            while (fis.read(bys) != -1) {
                line += new String(bys);
            }
            strArray = line.split(",");
            for (int i = 0; i < num; i++) {
                array[i] = Integer.parseInt(strArray[i]);
            }
        }
        fis.close();
        return array;
    }
}
