/**
 * @Author JiaWei Xu
 * @Date 2020-03-24 19:20
 * @Email xjwhhh233@outlook.com
 */
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int max=depth(root.left)+depth(root.right);
        return Math.max(Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)),max);
    }

    private int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(depth(root.left),depth(root.right));
    }
}
