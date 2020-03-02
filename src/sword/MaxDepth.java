package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-02 09:46
 * @Email xjwhhh233@outlook.com
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
