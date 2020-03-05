import java.util.Arrays;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-04 16:35
 * @Email xjwhhh233@outlook.com
 */
public class JumpGameII {
    public static int jump(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp, -1);
        dp[dp.length-1]=0;
        for(int i=nums.length-2;i>=0;i--){
            int min=Integer.MAX_VALUE;
            for(int j=i;j<=Math.min(i+nums[i],nums.length-1);j++){
                if(dp[j]!=-1){
                    min=Math.min(min,dp[j]+1);
                }
            }
            dp[i]=min==Integer.MAX_VALUE?-1:min;
        }
        return dp[0];

    }

    public int jump1(int[] nums) {
        int end=0;
        int maxPosition=0;
        int res=0;
        for(int i=0;i<nums.length-1;i++){
            maxPosition=Math.max(maxPosition,nums[i]+i);
            if(i==end){
                res++;
                end=maxPosition;
            }
        }
        return res;
    }



    public static void main(String[] args){
        int[] a={0};
        System.out.println(jump(a));
    }


}
