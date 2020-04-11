package spring2020.meituan;

/**
 * @Author JiaWei Xu
 * @Date 2020-04-03 12:12
 * @Email xjwhhh233@outlook.com
 */
public class Test {
    public static void main(String[] args){
        int n=3;
        double[] pro={0.9,0.1,0.1};
        double[] score={2,1,1};
        double[] dp=new double[n];
        double[] dpPro={0.9,0.1,0.1};
        dp[0]=pro[0]*score[0];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                double temp=dp[j]+dpPro[j]*dp[i-j-1];
                if(temp>dp[i]){
                    dp[i]=temp;
                    dpPro[i]=dpPro[j]*pro[i-j];
                }
            }
        }
        System.out.println(dp[n-1]);
    }
}
