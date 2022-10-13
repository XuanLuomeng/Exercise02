package day09;

import java.io.*;
import java.util.ArrayList;

public class GetArrangeByStack {
    public ArrayList<String> arrayList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/day09/file/permutation"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/day09/file/permutation_stack"));
        String[] str = {"1","2","3","4","5"};
        String[] strArray;
        String line;
        GetArrangeByStack stack = new GetArrangeByStack();
        while ((line = br.readLine()) != null) {
            stack.arrayList.clear();
            for (int len = 0; len < str.length; len++) {
                stack.arrayList.add(str[len]);
            }
            strArray = line.split("\\[")[1].split("]")[0].split(", ");
            for (String st : strArray) {
                boolean push = stack.push(st);
                if(push==false){
                    break;
                }
            }
            if(stack.arrayList.size()!=0){
                bw.write(line+"\t不能获取");
                bw.newLine();
            }else {
                String s = line+"\t";
                for (int len = 0; len < str.length; len++) {
                    s+=str[len]+" ";
                }
                bw.write(s);
                bw.newLine();
            }
        }
        bw.close();
        br.close();
    }

    public void add(String str) {
        arrayList.add(str);
    }

    public boolean push(String str) {
        String st = arrayList.get(arrayList.size() - 1);
        if (st.equals(str)) {
            arrayList.remove(str);
            return true;
        } else {
            return false;
        }
    }
}
