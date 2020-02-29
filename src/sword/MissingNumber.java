package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-29 18:48
 * @Email xjwhhh233@outlook.com
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int left=0;
        int right=nums.length;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]!=mid){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}
