package OJ2019.homework.reviewer;

import java.util.Scanner;

public class dyp_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        for (int i = 0; i < total; i++) {
            int n = scanner.nextInt();
            int h = scanner.nextInt();
            int p = scanner.nextInt();

            int[] time = new int[n];
            int[] score = new int[n];

            for (int j = 0; j < n; j++) {
                time[j] = scanner.nextInt();
                score[j] = scanner.nextInt();
            }

            helper(n,h,p,time,score);
        }
    }

    private static void helper(int n,int h,int p,int[] time,int[] score){
        int[][] dp=new int[n+1][h+1];
        for(int i=0;i<h+1;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<h+1;j++){
                if(j>=time[i-1]){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-time[i-1]]+score[i-1]);
                    if(dp[i][j]>p){
                        min=Math.min(min,j);
                    }
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
//        for(int i=1;i<n+1;i++) {
//            for (int j = 0; j < h + 1; j++) {
//                if (dp[i][j] >= p) {
//                    System.out.println("YES " + j);
//                    return;
//                }
//            }
//        }
        if(min!=Integer.MAX_VALUE){
            System.out.println("YES " + min);
        }else {
            System.out.println("NO");
        }

    }


}
