/**
 * @Author JiaWei Xu
 * @Date 2020-02-02 19:07
 * @Email xjwhhh233@outlook.com
 */
public class CountCompleteTreeNodes {
    int count=0;
    public int countNodes(TreeNode root) {
        helper(root);
        return count;
    }

    private void helper(TreeNode root){
        if(root==null){
            return;
        }
        count++;
        helper(root.left);
        helper(root.right);
    }
}
