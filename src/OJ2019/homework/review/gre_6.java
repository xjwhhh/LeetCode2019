package OJ2019.homework.review;

import java.util.Scanner;

public class gre_6 {
    //动态规划本质上是错的，因为他可以向左向上移动
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            int n = scan.nextInt();
            int[][] matrix=new int[n][n];
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    matrix[j][k]=scan.nextInt();

                }
            }
            helper(matrix,n);
        }
    }

    private static void helper(int[][] matrix,int n){
//        System.out.println(n);
        int[][] dp=new int[n][n];
        dp[0][0]=matrix[0][0];
        for(int i=1;i<n;i++){
            dp[0][i]=dp[0][i-1]+matrix[0][i];
//            System.out.println(dp[0][i]);
        }
        for(int i=1;i<n;i++){
            dp[i][0]=dp[i-1][0]+matrix[i][0];
//            System.out.println(dp[i][0]);
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+matrix[i][j];
            }
        }
        System.out.println(dp[n-1][n-1]);
    }

}
