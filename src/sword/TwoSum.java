package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-02 10:24
 * @Email xjwhhh233@outlook.com
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            if(nums[left]+nums[right]>target){
                right--;
            } else if(nums[left]+nums[right]<target){
                left++;
            }else{
                int[] result=new int[2];
                result[0]=nums[left];
                result[1]=nums[right];
                return result;
            }
        }
        return new int[2];

    }
}
