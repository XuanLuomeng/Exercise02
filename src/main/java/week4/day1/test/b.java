package week4.day1.test;

import java.util.Scanner;

public class b {
    int []number_arr;
    public void setNum(int index,int value){
        number_arr[index]=value;
    }
    public int getNum(int index){
        return number_arr[index];
    }
    public int compare(b a){
        int i=0;
        int j=0;
        a.number_arr=new int[3];
        while(i<a.number_arr.length&&j<this.number_arr.length){
            if(a.number_arr[i]<this.number_arr[i]){
                return -1;
            }else if(a.number_arr[i]>this.number_arr[i]){
                return 1;
            }
            else{
                i++;
                j++;
            }
        }
        if(i==a.number_arr.length&&j==this.number_arr.length){
            return 0;
        }else if(i<a.number_arr.length){
            return 1;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int []number_arr1={1,2,3,4,5,0,3,2};
        b t=new b();
        t.number_arr=number_arr1;
        t.setNum(t.number_arr.length-1, 5);
        System.out.println(10/t.getNum(3));

        int a=t.compare(new b());

        System.out.println(a);

    }

}
