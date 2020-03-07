import java.util.ArrayList;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-07 12:25
 * @Email xjwhhh233@outlook.com
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if(nums==null||nums.length==0){
            return 1;
        }
        ArrayList<Integer> list=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        int min=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) {
                list.add(nums[i]);
                max=Math.max(max,nums[i]);
//                min=Math.min(min,nums[i]);
            }
        }
        if(max!=Integer.MAX_VALUE){
            max+=1;
        }
        for(int i=min;i<=max;i++){
            if(!list.contains(i)){
                return i;
            }
        }
        return 1;

    }

    public int firstMissingPositive1(int[] nums) {
        int len=nums.length;
        for(int i=0;i<nums.length;i++){
            while(nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]){
                swap(nums,nums[i]-1,i);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}
