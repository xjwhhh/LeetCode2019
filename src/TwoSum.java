import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> a=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            a.put(nums[i],i);
        }
        for(int i=0;i<a.size();i++){
            int extra=target-nums[i];
            if(a.containsKey(extra)&&a.get(extra)!=i){
                return new int[]{i,a.get(extra)};
            }
        }
        return null;

    }
}
