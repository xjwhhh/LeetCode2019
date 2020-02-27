package sword;

import java.util.HashMap;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-27 16:28
 * @Email xjwhhh233@outlook.com
 */
public class ZeroSeven {
    int index=0;
    int[] preOrder;
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0){
            return null;
        }
        this.preOrder=preorder;
        int idx=0;
        for (Integer val : inorder)
            map.put(val, idx++);

        return helper(0,inorder.length-1);
    }

    private TreeNode helper(int left,int right){
        if(left>right){
            return null;
        }
        int middle=map.get(preOrder[index]);
//        for(int i=left;i<=right;i++){
//            if(inOrder[i]==this.preOrder[index]){
//                middle=i;
//            }
//        }
        TreeNode treeNode=new TreeNode(this.preOrder[index]);
        index++;
        treeNode.left=helper(left,middle-1);
        treeNode.right=helper(middle+1,right);
        return treeNode;

    }
}
