public class BalancedBinaryTree {
    //自顶向下
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        return Math.abs(leftDepth-rightDepth)<=1&&isBalanced(root.left)&&isBalanced(root.right);

    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }


    //自底向上，提前阻断
    public boolean isBalanced1(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        if(left == -1) return -1;
        int right = depth(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


}
