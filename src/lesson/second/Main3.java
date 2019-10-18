package lesson.second;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            int b[] = new int[n];
            for (int j = 0; j < n; j++)
                b[j] = sc.nextInt();
            dp(b, n, k);
        }
    }

    static int cal(int arr[], int from, int to) {
        int total = 0;
        for (int i = from; i <= to; i++)
            total += arr[i];
        return total;
    }

    //动态规划
    static void dp(int arr[], int n, int k) {
        int dp[][] = new int[k + 1][n + 1];

        for (int i = 1; i <= n; i++)
            dp[1][i] = cal(arr, 0, i - 1);

        for (int i = 1; i <= k; i++)
            dp[i][1] = arr[0];

        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                int best = Integer.MAX_VALUE;
                for (int p = 1; p <= j; p++)
                    best = Math.min(best, Math.max(dp[i - 1][p],
                            cal(arr, p, j - 1)));
                dp[i][j] = best;
            }
        }
        System.out.println(dp[k][n]);
    }
}
