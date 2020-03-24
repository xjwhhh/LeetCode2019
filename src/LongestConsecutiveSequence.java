import java.util.HashSet;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-19 16:58
 * @Email xjwhhh233@outlook.com
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int max=0;
        HashSet<Integer> hashSet=new HashSet<>();
        for(int num:nums){
            hashSet.add(num);
        }
        for(int num:nums){
            if(!hashSet.contains(num-1)){
                int curr=num+1;
                int count=1;
                while(hashSet.contains(curr)){
                    count++;
                    curr++;
                }
                max=Math.max(max,count);

            }
        }
        return max;

    }
}
