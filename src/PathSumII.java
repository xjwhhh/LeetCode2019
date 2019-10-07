import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        List<Integer> temp=new ArrayList<>();
        helper(root,sum,temp,result);
        return result;


    }

    private void helper(TreeNode root, int sum, List<Integer> temp,List<List<Integer>> result){
        if(root==null){
            return;
        }
        temp.add(root.val);
        if(root.val==sum&&root.left==null&&root.right==null) {
            result.add(new ArrayList<>(temp));
        }
        helper(root.left, sum - root.val, temp,result);
        helper(root.right,sum-root.val,temp,result);
        //回溯
        temp.remove(temp.size()-1);

    }
}
