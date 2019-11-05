import java.util.Arrays;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp=new int[366];
        boolean[] travel=new boolean[366];
        Arrays.fill(travel,false);
        for(int i=0;i<days.length;i++){
            travel[days[i]]=true;
        }
        for(int i=1;i<=days[days.length-1];i++){
            if(travel[i]){
                dp[i]=Math.min(getDp(i-1,dp)+costs[0],Math.min(getDp(i-7,dp)+costs[1],getDp(i-30,dp)+costs[2]));
            }else{
                dp[i]=dp[i-1];
            }
        }

        return dp[days[days.length-1]];

    }

    private int getDp(int index,int[] dp){
        if(index<0){
            return 0;
        }else{
            return dp[index];
        }
    }
}
