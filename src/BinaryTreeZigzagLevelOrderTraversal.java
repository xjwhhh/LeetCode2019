import java.util.ArrayList;
import java.util.List;

/**
 * @Author JiaWei Xu
 * @Date 2020-01-30 15:35
 * @Email xjwhhh233@outlook.com
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    List<List<Integer>> levels=new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return levels;
        }
        helper(root,0);
        return levels;

    }

    private void helper(TreeNode root,int level){
        if(root==null){
            return;
        }
        if(level>levels.size()){
            levels.add(new ArrayList<>());
        }
        if(level%2==0) {
            levels.get(level).add(root.val);
        }else{
            levels.get(level).add(0,root.val);
        }
        helper(root.left,level+1);

        helper(root.right,level+1);

    }




}
