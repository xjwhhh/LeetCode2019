/**
 * @Author JiaWei Xu
 * @Date 2020-02-03 12:46
 * @Email xjwhhh233@outlook.com
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode temp=root.right;
        root.right=root.left;
        root.left=temp;
        helper(root.right);
        helper(root.left);

    }
}
