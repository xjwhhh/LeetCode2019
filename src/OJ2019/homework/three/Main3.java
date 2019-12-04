package OJ2019.homework.three;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            int[] array=trans(scan.nextLine().split(" "));
            int[] nums=trans(scan.nextLine().split(" "));
            helper(array,nums);
        }
    }

    private static void helper(int[] array,int[] nums){
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            for (int k=num; k<array.length; k++) {
                for (int j=k; j>=num && array[j]<array[j-num]; j -= num) {
                    int temp = array[j-num];
                    array[j-num] = array[j];
                    array[j] = temp;
                }
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<array.length;i++){
           stringBuilder.append(array[i]+" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        System.out.println(stringBuilder);
    }

    private static int[] trans(String[] array){
        int[] result=new int[array.length];
        for(int i=0;i<array.length;i++){
//            System.out.println(array[i]);
            result[i]=Integer.parseInt(array[i]);
        }
        return result;
    }
}
