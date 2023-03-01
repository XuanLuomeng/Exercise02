package week3.day15;

import week1.day03.util.ReadFile;

import java.io.*;

public class fileSpliting {
    public static void main(String[] args) throws IOException {
        String file = "src/main/java/day15/datafile.txt";
        int[] array;
        ReadFile rf = new ReadFile();
        array = rf.read(file, 10000);
        String file1 = "src/main/java/day15/datafile1.txt";
        String file2 = "src/main/java/day15/datafile2.txt";
        String file3 = "src/main/java/day15/datafile3.txt";
        String file4 = "src/main/java/day15/datafile4.txt";
        BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter(file1));
        for (int i = 0; i < 2500; i++) {
            bufferedWriter1.write(array[i]+",");
            bufferedWriter1.flush();
        }
        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2));
        for (int i = 2500; i < 5000; i++) {
            bufferedWriter2.write(array[i]+",");
            bufferedWriter2.flush();
        }
        BufferedWriter bufferedWriter3 = new BufferedWriter(new FileWriter(file3));
        for (int i = 5000; i < 7500; i++) {
            bufferedWriter3.write(array[i]+",");
            bufferedWriter3.flush();
        }
        BufferedWriter bufferedWriter4 = new BufferedWriter(new FileWriter(file4));
        for (int i = 7500; i < 10000; i++) {
            bufferedWriter4.write(array[i]+",");
            bufferedWriter4.flush();
        }
    }
}
