package OJ2019.homework.reviewer;

import java.util.Scanner;

public class gre_4 {
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
        int tempsum=sum;
//        System.out.println(tempsum);
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
        int temp=Integer.MIN_VALUE;
        for(int i=0;i<coin.length;i++){
            if(tempsum%coin[i]==0){
                temp=Math.max(tempsum/coin[i],temp);
//                System.out.println(coin[i]);
//                System.out.println(temp);
            }
        }
        int last=-1;
        if(temp!=Integer.MIN_VALUE){
            last=temp;
        }
        if(sum==0){
            last=Math.min(last,result);

        }


//        else{
//            System.out.println(-1);
//        }
        System.out.println(last);

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

    private static void cal ( int n  ,int amount,int [] data){
        int [][] dp = new int[n+1][amount+1];
        for( int i =1;i<=amount;i++){
            dp[1][i] = i%data[0]==0?i/data[0]:0;
        }
        for( int  i =2;i<=n;i++){
            for( int j  =1;j<=amount;j++){
                int temp =  j%data[i-1]==0?j/data[i-1]:Integer.MAX_VALUE;
                int bb = 0;
                for( int k =  0;j-k*data[i-1]>0;k++){
                    if(dp[i-1][j-k*data[i-1]]==0){
                        continue;
                    }
                    bb = Math.min(temp,dp[i-1][j-k*data[i-1]]+dp[i][k*data[i-1]]);
                }
                dp[i][j]  =  Math.min(temp,bb);
            }
        }
        System.out.println(dp[n][amount]==0?-1:dp[n][amount]);
    }
}
