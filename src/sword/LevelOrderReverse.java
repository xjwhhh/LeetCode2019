package sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * @Author JiaWei Xu
 * @Date 2020-02-28 16:21
 * @Email xjwhhh233@outlook.com
 */
public class LevelOrderReverse {
    public List<List<Integer>> levelOrder(TreeNode root) {
        boolean flag=false;
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> curr = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        curr.add(root);
        while (!curr.isEmpty()) {
            next.clear();
            List<Integer> list = new ArrayList<>();
            int size=curr.size();
            System.out.println(size);
            for(int i=0;i<size;i++){
                TreeNode temp = curr.get(i);
                if (temp.left != null) {
                    next.add(temp.left);
                }
                if (temp.right != null) {
                    next.add(temp.right);
                }
            }
            if(flag) {
                for (int i = 0; i < size; i++) {
                    TreeNode temp = curr.get(i);
                    list.add(temp.val);
                }
            }else{
                for (int i = size; i > 0; i--) {
                    TreeNode temp = curr.get(i);
                    list.add(temp.val);
                }
            }
            result.add(list);
            System.out.println(next.size());
            curr=new LinkedList<>(next);
            flag=!flag;
        }
        return result;
    }
}
