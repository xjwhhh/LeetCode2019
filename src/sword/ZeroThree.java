package sword;

import java.util.HashSet;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-27 10:21
 * @Email xjwhhh233@outlook.com
 */
public class ZeroThree {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> hashSet=new HashSet<>();
        for(int num:nums){
            if(!hashSet.add(num)){
                return num;
            }
        }
        return 0;
    }

    public int findRepeatNumber1(int[] nums) {
        int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }

}
