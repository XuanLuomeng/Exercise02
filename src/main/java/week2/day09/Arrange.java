package week2.day09;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arrange {
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/java/day09/file/permutation"));
        int[] arr = {1, 2, 3, 4, 5};
        wholeArrangement(arr,new ArrayList<>());
        for(List<Integer> re: res){
            bufferedWriter.write(re.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public static List<List<Integer>> wholeArrangement(int[] arr, List<Integer> list) {
        List<Integer> temp = new ArrayList<>(list);
        if(arr.length==list.size()){
            res.add(temp);
        }
        for (int len = 0; len < arr.length; len++) {
            if(temp.contains(arr[len])){
                continue;
            }
            temp.add(arr[len]);
            wholeArrangement(arr,temp);
            temp.remove(temp.size()-1);
        }
        return res;
    }
}
