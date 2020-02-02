import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author JiaWei Xu
 * @Date 2020-01-31 14:34
 * @Email xjwhhh233@outlook.com
 */
public class BinaryTreeRightSideView {

    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return list;
    }
    public void helper(TreeNode root, int n) {
        if (root == null) return;
        if (n == list.size()) list.add(root.val);
        helper(root.right, n + 1);
        helper(root.left, n + 1);
    }
}
