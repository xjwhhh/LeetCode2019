package sword;

import java.util.ArrayList;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-02 09:40
 * @Email xjwhhh233@outlook.com
 */
public class KthLargest {

    public int kthLargest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
        ArrayList<TreeNode> array=new ArrayList<>();
        helper(array,root);
        if(array.size()>=k){
            return array.get(k-1).val;
        }else{
            return 0;
        }



    }

    private void helper(ArrayList<TreeNode> array,TreeNode root){
        if(root==null){
            return;
        }
        helper(array,root.right);
        array.add(root);
        helper(array,root.left);

    }
}
