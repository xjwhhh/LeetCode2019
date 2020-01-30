import java.util.HashMap;

/**
 * @Author JiaWei Xu
 * @Date 2020-01-30 19:13
 * @Email xjwhhh233@outlook.com
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    int[] postOrder;
    int[] inOrder;
    HashMap<Integer, Integer> idx_map = new HashMap<>();

    int rootIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0){
            return null;
        }
        this.postOrder =postorder;
        this.inOrder=inorder;
        rootIndex=postorder.length-1;

        int idx=0;
        for (Integer val : inorder)
            idx_map.put(val, idx++);

        return helper(0,inorder.length-1);

    }


    private TreeNode helper(int left,int right){
        if(left>right){
            return null;
        }
        int rootVal=postOrder[rootIndex];
        TreeNode root=new TreeNode(rootVal);
        int index=idx_map.get(rootVal);
        rootIndex--;

        root.right=helper(index+1,right);
        root.left=helper(left,index-1);

        return root;


    }
}
