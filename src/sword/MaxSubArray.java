package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-29 15:52
 * @Email xjwhhh233@outlook.com
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int result=nums[0];
        int count=nums[0];
        if(count<0){
            count=0;
        }
        for (int i=1;i<nums.length;i++) {
            count+=nums[i];
            if(count>result){
                result=count;
            }
            if(count<0){
                count=0;
            }
        }
        return result;

    }
}
