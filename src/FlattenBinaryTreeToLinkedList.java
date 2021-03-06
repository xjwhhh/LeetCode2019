import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        helper(root,result);
        TreeNode temp=root;
        for(int i=1;i<result.size();i++){
            temp.right=new TreeNode(result.get(i));
            temp.left=null;
            temp=temp.right;
        }
    }

    private void helper(TreeNode root,List<Integer> result){
        if (root==null){
            return;
        }
        result.add(root.val);
        helper(root.left,result);
        helper(root.right,result);

    }

    public void flatten1(TreeNode root){
        while(root!=null){
            if(root.left==null){
                root=root.right;
            }else{
                TreeNode temp=root.left;
                while(temp.right!=null){
                    temp=temp.right;
                }
                temp.right=root.right;
                root.right=root.left;
                root.left=null;
                root=root.right;
            }
        }

    }

}
