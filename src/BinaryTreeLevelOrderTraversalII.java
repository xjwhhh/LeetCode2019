import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode tempNode=queue.poll();
                temp.add(tempNode.val);
                if(tempNode.left!=null){
                    queue.offer(tempNode.left);
                }
                if(tempNode.right!=null){
                    queue.offer(tempNode.right);
                }
            }
            result.add(0,temp);
        }
        return result;


    }
}
