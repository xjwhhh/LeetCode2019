import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-03 13:03
 * @Email xjwhhh233@outlook.com
 */
public class LowestCommonAncestorOfABinarySearchTree {

    List<TreeNode> pList=new ArrayList<>();
    List<TreeNode> qList=new ArrayList<>();
    int pValue=0;
    int qValue=0;
    TreeNode p=null;
    TreeNode q=null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pValue=p.val;
        qValue=q.val;
        this.p=p;
        this.q=q;
        List<TreeNode> path=new ArrayList<>();
        helper(root,path);
        return find();
    }

    private void helper(TreeNode root,List<TreeNode> path){
        if(root==null){
            return;
        }
        if(root.val==pValue){
            path.add(root);
            pList=path;
            if(qList.size()!=0) {
                return;
            }
        }
        if(root.val==qValue){
            path.add(root);
            qList=path;
            if(pList.size()!=0) {
                return;
            }
        }
        path.add(root);
        helper(root.left,new ArrayList<>(path));
        helper(root.right,new ArrayList<>(path));
    }

    private TreeNode find(){
        if(qList.contains(p)){
            return p;
        }
        if(pList.contains(q)){
            return q;
        }
        List<TreeNode> s=new ArrayList<>();
        List<TreeNode> l=new ArrayList<>();
        if(pList.size()<=qList.size()){
            s=pList;
            l=qList;
        }else{
            l=pList;
            s=qList;
        }
        for(int i=s.size()-1;i>=0;i--){
            if(l.contains(s.get(i))){
                return s.get(i);
            }
        }
        return null;
    }


    //要注意二叉搜索树的性质
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        // Value of current node or parent node.
        int parentVal = root.val;

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            // If both p and q are greater than parent
            return lowestCommonAncestor1(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor1(root.left, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }

}
