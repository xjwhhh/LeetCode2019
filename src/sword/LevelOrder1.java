package sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-28 16:07
 * @Email xjwhhh233@outlook.com
 */
public class LevelOrder1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> curr = new LinkedList<>();
        curr.add(root);
        while (!curr.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size=curr.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = curr.poll();
                list.add(temp.val);
                System.out.println(temp.val);
                if (temp.left != null) {
                    curr.add(temp.left);
                }
                if (temp.right != null) {
                    curr.add(temp.right);
                }
            }
            result.add(list);
        }
        return result;

    }
}
