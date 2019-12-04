package OJ2019.homework.review;

import java.util.Scanner;

public class dyp_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        for(int i=0;i<total;i++){
            int n=scanner.nextInt();
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            int []A = new int[n];
            int []B = new int[n];
            for(int j=0;j<n;j++){
                A[j]=scanner.nextInt();
            }
            for(int k=0;k<n;k++){
                B[k]=scanner.nextInt();
            }
            System.out.println(getMaxTip(x,y,n,A,B));
        }
    }

    private static int getMaxTip(int x, int y, int n, int[] A, int[] B) {
        int[][] dp = new int[x + 1][y + 1];

        dp[0][0] = 0;
        for (int i = 1;i <= x;i++) {
            dp[i][0] = (i <= n) ? dp[i - 1][0] + A[i - 1] : dp[i - 1][0];
        }

        for (int i = 1;i <= y;i++) {
            dp[0][i] = (i <= n) ? dp[0][i - 1] + B[i - 1] : dp[0][i - 1];
        }

        for (int i = 1;i <= x;i++) {
            for (int j = 1;j <= y;j++) {
                if (i + j <= n) {
                    dp[i][j] = Math.max(dp[i - 1][j] + A[i + j - 1], dp[i][j - 1] + B[i + j - 1]);
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0;i <= x;i++) {
            for (int j = 0;j <= y;j++) {
                if (i + j == n) {
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}