package day10;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IsSerial {
    static String op="";
    static int cnt;
    public static int sum=1;
    public static  int fn(int n)
    {
        if(n>1)
        {
            sum*=n;
            return fn(n-1);
        }
        else
        {
            return sum;
        }
    }
    public static boolean isSerial(int []b)
    {
        int index,step,n=b.length;
        Integer e;
        int[] a=new int[n];
        Stack<Integer> st=new Stack<Integer>();
        for(index=0;index<n;index++)
        {
            a[index]=index+1;
        }
        index=0;step=0;
        while(index<n)//when the b run end
        {
            st.push(a[index]);
            op+=" 元素"+a[index]+"进栈\n";
            index++;
            while(!st.empty()&&st.peek()==b[step])//the top of the stack equal to the b
            {
                e=st.pop();
                op+=" 元素"+e+"出栈\n";
                step++;
            }
        }
        return st.empty();//if empty true
    }
    public static void solve(int[] b, FileWriter fw) throws IOException
    {
        for(int index=0;index<b.length;index++)
        {
            System.out.print(" "+b[index]);
        }
        System.out.println();
        if(isSerial(b))
        {
            System.out.println("是合法出栈序列");
            System.out.println(op);
        }
        else
        {
            String s = "不能获得";
            for(int index=0;index<b.length;index++)
            {
                s+=b[index];
            }
            fw.write(s+"\n");
            System.out.println(s);
        }
    }
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        FileWriter fw=new FileWriter("src/main/java/day10/permutation_stack.txt");
        FileReader fr=new FileReader("src/main/java/day10/permutation.txt");
        System.out.println("测试1");
        int data[]=new int[5];
        int ind=0;
        int le=fn(5);
        while(ind<le)
        {
            for(int index=0;index<data.length;index++)
            {
                data[index]=fr.read();
            }
            ind++;
            solve(data,fw);
        }
        fr.close();
        fw.close();
    }
}
