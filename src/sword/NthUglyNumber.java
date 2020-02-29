package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-29 17:21
 * @Email xjwhhh233@outlook.com
 */
public class NthUglyNumber {
    public static int nthUglyNumber(int n) {
        int p2=0;
        int p3=0;
        int p5=0;
        int[] dp=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            dp[i]=Math.min(dp[p2]*2,Math.min(dp[p3]*3,dp[p5]*5));
            if(dp[i]==dp[p2]*2) p2++;
            if(dp[i]==dp[p3]*3) p3++;
            if(dp[i]==dp[p5]*5) p5++;
        }
        return dp[n-1];
    }

    public static void main(String[] args){
        nthUglyNumber(10);
    }

}
