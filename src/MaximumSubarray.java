public class MaximumSubarray {
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        int max = nums[0];
        int sum = nums[0];
        for(int i=1;i<n;i++){
            sum = Math.max(sum+nums[i], nums[i]);
            if(sum>=max){
                max = sum;
            }
        }
        return max;



    }
}
