package spring2020.meituan;

import java.util.Scanner;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-12 19:52
 * @Email xjwhhh233@outlook.com
 */
public class Three {

    static int n;
    static int k;
    static int L;
    static int R;
    static Long result=0L;
    static Long[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        k=scanner.nextInt();
        L=scanner.nextInt();
        R=scanner.nextInt();
        dp=new Long[n+1][k];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=0L;
            }
        }
        helper();
        System.out.println(result%1000000007);
    }

    private static void helper(){
        for(int j=1;j<=n;j++ ) {
            for (int i = L; i <= R; i++) {
//            System.out.println(i%k);
                dp[j][i % k] += 1;
            }
        }
        for(int i=0;i<dp[0].length;i++){
            for(int j=1;j<dp.length;j++){
                for(int t=L;t<=R;t++){
                    int temp=t%k;
                    dp[j][i]+=dp[j-1][k-temp];
                    dp[j][i]%=1000000007;
                }
            }
        }
        result=dp[n][0];
//        System.out.println(dp[n][0]);
    }
}
