package sword;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-29 10:32
 * @Email xjwhhh233@outlook.com
 */
public class PathSum {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result=new ArrayList<>();
        if(root==null){
            return result;
        }
        helper(root,sum,new ArrayList<>());
        return result;


    }

    private void helper(TreeNode root,int sum,List<Integer> path){
        if(root==null){
            return;
        }
        if(root.val==sum&&root.left==null&&root.right==null){
            path.add(root.val);
            result.add(new ArrayList<>(path));
            return;
        }
        path.add(root.val);
        if(root.left!=null) {
            helper(root.left, sum - root.val, path);
            path.remove(path.size()-1);
        }
        if(root.right!=null) {
            helper(root.right, sum - root.val, path);
            path.remove(path.size()-1);
        }

    }
}
