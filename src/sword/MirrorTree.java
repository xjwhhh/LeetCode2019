package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-28 14:36
 * @Email xjwhhh233@outlook.com
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode temp=mirrorTree(root.left);
        root.left=mirrorTree(root.right);
        root.right=temp;
        return root;
    }
}
