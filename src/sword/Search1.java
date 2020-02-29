package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-29 18:33
 * @Email xjwhhh233@outlook.com
 */
public class Search1 {
    public int search(int[] nums, int target) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                count++;
            }
            if(nums[i]>target){
                break;
            }
        }
        return count;

    }


    //二分查找
    public int search1(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int left = binarySearch(nums, target, true);
        if(left == -1) return 0;
        int right = binarySearch(nums, target, false);
        return right - left;
    }
    public int binarySearch(int nums[],int target,boolean leftFlag){
        int left,mid,right;
        left = mid = 0;
        right = nums.length;
        while(left < right){
            mid = (left+right)/2;
            if(nums[mid]>target||(leftFlag&&nums[mid]==target)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
