import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len=primes.length;
        int[] index=new int[len];
        int[] dp=new int[n];
        dp[0]=1;

        for(int i=1;i<n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<len;j++){
                int temp=dp[index[j]]*primes[j];
                if(temp<min) {
                    min = temp;
                }
            }
            dp[i]=min;
            for(int j=0;j<len;j++) {
                int temp = dp[index[j]] * primes[j];
                if(temp==min){
                    index[j]++;
                }
            }
            System.out.println(i);
            System.out.println(min);
        }
        return dp[n-1];

    }
}
