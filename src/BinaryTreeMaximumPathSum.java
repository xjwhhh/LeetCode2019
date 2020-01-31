/**
 * @Author JiaWei Xu
 * @Date 2020-01-31 13:19
 * @Email xjwhhh233@outlook.com
 */
public class BinaryTreeMaximumPathSum {
    private int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=Math.max(helper(root.left),0);
        int right=Math.max(helper(root.right),0);
        int temp=root.val+left+right;
        max=Math.max(temp,max);
        return root.val+Math.max(left,right);
    }
}
