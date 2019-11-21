package lesson.four;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String numArray=scan.nextLine();
            String[] str=scan.nextLine().split(" ");
            int[] array=trans(str);
            helper(array);
        }
    }

    private static void helper(int[] array){
        int max=Integer.MIN_VALUE;
       for(int i=0;i<array.length;i++){
           int temp=array[i];
           array[i]=0;
           int sum=maxSubArray(array);
//           System.out.println(sum);
           if(sum>max){
               max=sum;
           }
           array[i]=temp;
       }
        int sum=maxSubArray(array);
//        System.out.println(sum);
        if(sum>max){
            max=sum;
        }

       System.out.println(max);
    }

    private static int  maxSubArray(int[] array){
        int max=Integer.MIN_VALUE;
        int sum=array[0];
        for(int i=1;i<array.length;i++){
            sum=Math.max(sum+array[i],array[i]);
            if(sum>max){
                max=sum;
            }
        }
        return max;


    }

    private static int[] trans(String[] array){
       int[] result=new int[array.length];
        for(int i=0;i<array.length;i++){
            result[i]=(Integer.parseInt(array[i]));
        }
        return result;
    }

}
