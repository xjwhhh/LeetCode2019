import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int t=nums[i];
            int count=hashMap.getOrDefault(t,0)+1;
            if(count>nums.length/2){
                return t;
            }
            hashMap.put(t,count);
        }
        return 0;
    }
}
