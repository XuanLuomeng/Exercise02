package week2.day13;

import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        String str = new String();
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/day13/file"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] strArray = line.split(" ");
            for (int size = 0; size < strArray.length; size++) {
                str += strArray[size];
            }
        }
        br.close();
        String strChar = "abcdefghijklmnopqrstuvwxyz,.";
        Integer[] key = new Integer[28];
        String[] strArray = str.split("");
        for (int i = 0; i < key.length; i++) {
            key[i] = new Integer(0);
        }
        for (String string : strArray) {
            if (string.equals("a")) {
                key[0]++;
            } else if (string.equals("b")) {
                key[1]++;
            } else if (string.equals("c")) {
                key[2]++;
            } else if (string.equals("d")) {
                key[3]++;
            } else if (string.equals("e")) {
                key[4]++;
            } else if (string.equals("f")) {
                key[5]++;
            } else if (string.equals("g")) {
                key[6]++;
            } else if (string.equals("h")) {
                key[7]++;
            } else if (string.equals("i")) {
                key[8]++;
            } else if (string.equals("j")) {
                key[9]++;
            } else if (string.equals("k")) {
                key[10]++;
            } else if (string.equals("l")) {
                key[11]++;
            } else if (string.equals("m")) {
                key[12]++;
            } else if (string.equals("n")) {
                key[13]++;
            } else if (string.equals("o")) {
                key[14]++;
            } else if (string.equals("p")) {
                key[15]++;
            } else if (string.equals("q")) {
                key[16]++;
            } else if (string.equals("r")) {
                key[17]++;
            } else if (string.equals("s")) {
                key[18]++;
            } else if (string.equals("t")) {
                key[19]++;
            } else if (string.equals("u")) {
                key[20]++;
            } else if (string.equals("v")) {
                key[21]++;
            } else if (string.equals("w")) {
                key[22]++;
            } else if (string.equals("r")) {
                key[23]++;
            } else if (string.equals("x")) {
                key[24]++;
            } else if (string.equals("z")) {
                key[25]++;
            } else if (string.equals(",")) {
                key[26]++;
            } else if (string.equals(".")) {
                key[27]++;
            }
        }
        Huffman huffman = new Huffman();
        huffman.setData(28, key, strChar);
        huffman.createHuffmanTree();
        huffman.createHuffmanCode();
        huffman.DispHuffman();

        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/day13/file2"));
        String[] split = str.split("");
        for (String sp : split) {
            for (int size = 0; size < huffman.n; size++) {
                if (huffman.huffmanTree[size].date.equals(sp)) {
                    bw.write(huffman.huffmanCode[size]);
                    bw.newLine();
                    continue;
                }
            }
        }
        bw.close();
    }
}
