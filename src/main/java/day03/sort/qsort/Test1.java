package day03.sort.qsort;

public class Test1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] array;
        array = new int[]{4881,16282,21068,22308,25366,4749,26870,26525,7001,23813,18916,20793,28600,6055,11465,27783,23973,6222,29086,2680,18087,21523,29277,2593,6426,11613,16298,8598,24696,25857,2735,14736,3329,8353,4772,88,18247,9747,23621,26564,29111,4194,10751,4241,17670,2041,15323,7405,24716,27973,26599,6645,13907,8019,17291,21078,21068,23578,14211,27720,12850,3990,9606,15342,4840,1446,7226,14393,2415,8036,24318,6066,16061,14312,7918,11110,15409,29576,16450,15470,20796,18628,8377,12834,7206,6100,8857,23782,17103,26513,26956,29738,6304,20898,7498,7445,10463,118,11966,11670};
        //用自写快排
        quickSort(array,0,array.length-1);
        long end = System.currentTimeMillis();
        System.out.println("用时:"+(end-start)+"ms");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        temp = arr[low];
        while (i<j) {
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        arr[low] = arr[i];
        arr[i] = temp;
        quickSort(arr, low, j-1);
        quickSort(arr, j+1, high);
    }
}
