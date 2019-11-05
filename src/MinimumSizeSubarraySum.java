public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int left=0;
        int right=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        while(left<nums.length-1){
//            System.out.println(sum);
            if(sum<s){
                if(right<nums.length-1){
                    right++;
                    sum += nums[right];
                }else{
                    break;
                }
            }else{
//                min=Math.min(min,right-left+1);
                sum-=nums[left];
                left++;
            }
            if(sum>=s){
                min=Math.min(min,right-left+1);
            }


        }
        if(min!=Integer.MAX_VALUE){
            return min;
        }else{
            return 0;
        }
    }
}
