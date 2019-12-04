package OJ2019.homework.two;

import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            String arrayString = scan.nextLine();
            String[] arrayStr = arrayString.split(" ");
            int[] array = new int[arrayStr.length];
            for (int j = 0; j < array.length; j++) {
                array[j] = Integer.parseInt(arrayStr[j]);
            }
            mergeSort(array);
            print(array);


        }
    }

    public static void mergeSort(int[] arr) {

        int result=sort(arr, 0, arr.length - 1);
        System.out.println(result);
    }

    public static int sort(int[] arr, int L, int R) {
        if(L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        int l=sort(arr, L, mid);
        int r=sort(arr, mid + 1, R);
        return merge(arr, L, mid, R,l+r);
    }

    public static int merge(int[] arr, int L, int mid, int R,int count) {
        int[] temp = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while(p1 <= mid && p2 <= R) {
            if(arr[p1]>arr[p2]){
                count+=mid-p1+1;
            }
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];

        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while(p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while(p2 <= R) {
            temp[i++] = arr[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for(i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
        return count;
    }

    private static void print(int[] array){
        StringBuilder res=new StringBuilder();
        for(int j=0;j<array.length-1;j++){
            res.append(array[j]);
            res.append(" ");
        }
        if(array.length-1>=0) {
            res.append(array[array.length - 1]);
        }
        System.out.println(res);
    }
}
