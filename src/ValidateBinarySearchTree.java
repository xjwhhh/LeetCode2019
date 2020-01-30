/**
 * @Author JiaWei Xu
 * @Date 2020-01-29 19:16
 * @Email xjwhhh233@outlook.com
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        return helper(root,null,null);

    }

    private boolean helper(TreeNode root,Integer low,Integer high){
        if(root==null){
            return true;
        }
        int val=root.val;
        if(low!=null&&val<=low){
            return false;
        }
        if(high!=null&&val>=high){
            return false;
        }

        //左子树的值要比val小
        if(!helper(root.left,low,val)){
            return false;
        }
        if(!helper(root.right,val,high)){
            return false;
        }
        return true;

    }
}
