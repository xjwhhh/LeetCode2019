package golden;

/**
 * @Author JiaWei Xu
 * @Date 2020-04-23 15:29
 * @Email xjwhhh233@outlook.com
 */
public class CheckBalance {

    boolean result=true;

    public boolean isBalanced(TreeNode root) {
        helper(root);
        return result;
    }

    private int helper(TreeNode root){
       if(root==null){
           return 0;
       }
       int left=helper(root.left);
       int right=helper(root.right);
       if(Math.abs(left-right)>1){
           result=false;

       }
       return Math.max(right,left)+1;

    }
}
