package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-02 09:50
 * @Email xjwhhh233@outlook.com
 */
public class IsBalanced {
    boolean flag=true;
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        helper(root);
        return flag;

    }

    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if(Math.abs(left-right)>1){
            flag = false;
        }
        return 1+Math.max(left, right);


    }
}
