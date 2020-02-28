package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-28 12:13
 * @Email xjwhhh233@outlook.com
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            while(left<=nums.length-1&&nums[left]%2==1){
                left++;
            }
            while(right>=0&&nums[right]%2==0){
                right--;
            }
            if(left<right&&nums[left]%2==0&&nums[right]%2==1){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                left++;
                right--;
            }
        }
        return nums;

    }
}
