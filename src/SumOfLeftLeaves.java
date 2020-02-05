/**
 * @Author JiaWei Xu
 * @Date 2020-02-05 16:39
 * @Email xjwhhh233@outlook.com
 */
public class SumOfLeftLeaves {
    int count=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return count;
        }
        helper(root,false);
        return count;

    }

    private void helper(TreeNode root,boolean flag) {
        if(flag&&root.left==null&&root.right==null){
            count+=root.val;
            return;
        }
        if(root.left!=null){
            helper(root.left,true);
        }
        if(root.right!=null){
            helper(root.right,false);
        }
    }
}
