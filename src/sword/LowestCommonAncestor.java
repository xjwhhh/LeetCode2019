package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-02 12:43
 * @Email xjwhhh233@outlook.com
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(p==null||q==null){
            return null;
        }
        if(p.val==q.val){
            return p;
        }
        if(p.val==root.val||q.val==root.val){
            return root;
        }
        if(p.val>root.val&&q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(p.val<root.val&&q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;



    }
}
