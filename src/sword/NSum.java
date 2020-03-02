package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-02 11:34
 * @Email xjwhhh233@outlook.com
 */
public class NSum {
    public double[] twoSum(int n) {
        int[][] dp=new int[n+1][n*6+1];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                dp[i][j]=0;
//            }
//        }
        for(int i=1;i<=6;i++){
            dp[1][i]=1;
        }

        for(int i=2;i<=n;i++){
            for(int j=i;j<=6*i;j++){
                for (int cur = 1; cur <= 6; cur ++) {
                    if (j - cur <= 0) {
                        break;
                    }
                    dp[i][j] += dp[i-1][j-cur];
                }
            }
        }
        double[] res=new double[5*n+1];
        double all=Math.pow(6,n);
        for(int i=n;i<=6*n;i++){
            res[i-n]=dp[n][i]*1.0/all;
        }
        return res;

    }
}
