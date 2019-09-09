import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        if(nums.length==0){
            return result;
        }
        List<Integer> pre=new ArrayList<>();
        helper(result,nums,pre,0);

        return result;

    }

    public void helper(List<List<Integer>> result,int[] nums,List<Integer> pre,int begin){

        result.add(new ArrayList<>(pre));
        for (int i = begin; i < nums.length; i++) {
            pre.add(nums[i]);
            helper(result,nums,pre, i + 1);
            pre.remove(pre.size() - 1);
        }
    }
}
