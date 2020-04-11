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

    //获取经过每个根节点的最长路径，用一个全局变量比较并保存
}
