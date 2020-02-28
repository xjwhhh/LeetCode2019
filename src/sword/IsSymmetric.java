package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-28 14:41
 * @Email xjwhhh233@outlook.com
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return helper(root.left,root.right);


    }

    private boolean helper(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        if(left.val==right.val){
            return helper(left.left,right.right)&&helper(left.right,right.left);
        }else{
            return false;
        }
    }

}
