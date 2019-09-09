import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        if(nums.length==0){
            return result;
        }
        List<Integer> pre=new ArrayList<>();
        Arrays.sort(nums);
        helper(result,nums,pre,0);

        return result;

    }

    public void helper(List<List<Integer>> result,int[] nums,List<Integer> pre,int begin){
        result.add(new ArrayList<>(pre));
        for(int i=begin;i<nums.length;i++){
            if(i>begin&&nums[i]==nums[i-1]){
                continue;
            }
            pre.add(nums[i]);
            helper(result,nums,pre, i + 1);
            pre.remove(pre.size() - 1);
        }
    }
}
