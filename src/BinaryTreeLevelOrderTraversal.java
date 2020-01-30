import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author JiaWei Xu
 * @Date 2020-01-30 15:05
 * @Email xjwhhh233@outlook.com
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        List<TreeNode> pre=new ArrayList<>();
        pre.add(root);
        List<TreeNode> curr=new ArrayList<>();

        while(!pre.isEmpty()){
            List<Integer> row=new ArrayList<>();
            curr.clear();
            for(int i=0;i<pre.size();i++){
                TreeNode temp=pre.get(i);
                row.add(temp.val);
                if(temp.left!=null){
                    curr.add(temp.left);
                }
                if(temp.right!=null){
                    curr.add(temp.right);
                }
            }
            pre=new ArrayList<>(curr);
           result.add(row);
        }
        return result;


    }
}
