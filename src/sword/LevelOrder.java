package sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-28 15:47
 * @Email xjwhhh233@outlook.com
 */
public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> array=new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            array.add(temp.val);
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
        int[] result=new int[array.size()];
        for(int i=0;i<result.length;i++){
            result[i]=array.get(i);
        }
        return result;

    }
}
