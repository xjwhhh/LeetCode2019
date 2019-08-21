import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:hashMap.entrySet()){
            if (entry.getValue()==1){
                return entry.getKey();
            }


        }

        return 0;
    }

    public int singleNumber1(int[] nums) {

        int ans = 0;
        int[]temp = new int[32];
        for(int num:nums)
        {
            int r = 1;
            int j = 31;
            while(j >= 0)
            {
                if((num&r) != 0)temp[j]++;
                j--;
                r = r << 1;
            }
        }
        int r = 1;
        int j = 31;

        while(j >= 0)
        {
            if(temp[j]%3 != 0)
                ans = ans ^ r;
            r = r << 1;
            j--;
        }

        return ans;
    }

}
