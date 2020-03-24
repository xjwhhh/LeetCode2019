package spring2020.alibishi;

import java.util.Scanner;

public class One {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int[] count=new int[10];
        for(int i=0;i<10;i++){
            count[i]=scanner.nextInt();
        }
//        System.out.println(3);
        helper(count);
    }


    private static void helper(int[] count){
        int max=0;
        int allNum=0;
        for(int num:count){
            max=Math.max(num,max);
            allNum+=num;
        }

        //只有一张牌的特殊情况
        if(allNum==1){
            System.out.println(1);
        }

    }
}
