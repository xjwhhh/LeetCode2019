package sword;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-29 15:19
 * @Email xjwhhh233@outlook.com
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry:hashMap.entrySet()){
            if(entry.getValue()>nums.length/2){
                return entry.getKey();
            }
        }
        return 0;
    }

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];

    }

    public int majorityElement2(int[] nums) {
        int target = nums[0];//初始化为数组的第一个元素，接下来用于记录上一次访问的值
        int count = 1;//用于记录出现次数
        for(int i = 1;i<nums.length;i++) {
            if(target == nums[i]) {
                count++;
            }else {
                count--;
            }
            if(count == 0) {//当count=0时，更换target的值为当前访问的数组元素的值，次数设为1
                target = nums[i];
                count = 1;
            }
        }
        return target;
    }
}
