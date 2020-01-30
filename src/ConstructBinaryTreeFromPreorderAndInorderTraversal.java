import java.util.HashMap;

/**
 * @Author JiaWei Xu
 * @Date 2020-01-30 18:50
 * @Email xjwhhh233@outlook.com
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    int[] preOrder;
    int[] inOrder;
    HashMap<Integer, Integer> idx_map = new HashMap<>();

    int rootIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        this.preOrder=preorder;
        this.inOrder=inorder;

        int idx=0;
        for (Integer val : inorder)
            idx_map.put(val, idx++);

        return helper(0,inorder.length-1);


    }

    private TreeNode helper(int left,int right){
        if(left>right){
            return null;
        }
        int rootVal=preOrder[rootIndex];
        TreeNode root=new TreeNode(rootVal);
        int index=idx_map.get(rootVal);
        rootIndex++;

        root.left=helper(left,index-1);
        root.right=helper(index+1,right);
        return root;


    }
}
