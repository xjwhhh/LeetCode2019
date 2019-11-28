package lesson.five;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            int coinType=scan.nextInt();
            int sum=scan.nextInt();
            int[] coin=new int[coinType];
            for(int j=0;j<coinType;j++){
                coin[j]=scan.nextInt();
            }
            helper(sum,coin);
        }
    }

    private static void helper(int sum, int[] coin){
        int result=0;
        while(sum!=0){
            int max=find(sum,coin);
//            System.out.println(max);
            if(max!=Integer.MIN_VALUE){
                sum-=max;
//                System.out.println(sum);
                result++;
            }else{
                break;
            }
        }
        if(sum==0){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }

    }

    private static int find(int sum, int[] coin){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<coin.length;i++){
            if(coin[i]>max&&sum>=coin[i]){
                max=coin[i];
            }
        }
        return max;
    }
}
