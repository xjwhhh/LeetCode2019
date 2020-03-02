package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-02 12:53
 * @Email xjwhhh233@outlook.com
 */
public class LowestCommonAncestor1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //返回节点存在情况
        if(root == null || p == root || q ==root)
            return root;
        //再左右子树寻找 p q 两个节点
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //情况1：如果右子树找不到 p 或 q 即(right==null)，
        //那么说明 p 和 q 都在左子树上，返回 left

        //情况2：如果左子树找不到 p 或 q 即(right==null)，
        //那么说明 p 和 q 都在右子树上，返回 right

        //如果上述情况都不符合，说明 p 和 q 分别在左子树和右子树，
        //那么最近公共节点为当前节点
        //直接返回 root 即可
        return (right == null) ? left : (left == null) ? right : root;
    }

}
