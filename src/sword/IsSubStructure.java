package sword;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-28 13:10
 * @Email xjwhhh233@outlook.com
 */
public class IsSubStructure {
    TreeNode saveB;
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A == null) {
            return false;
        }
        if (B == null) {
            return false;
        }
        saveB=B;
        return helper(A, B);


    }

    private boolean helper(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val == B.val) {
            if (helper(A.left, B.left) && helper(A.right, B.right)) {
                return true;
            }
        }
        if (helper(A.left, saveB) || helper(A.right, saveB)) {
            return true;
        }

        return false;
    }

    public boolean isSubStructure1(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return DFS(A,B) || isSubStructure1(A.left,B) || isSubStructure1(A.right,B);
    }

    public boolean DFS(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        return A.val == B.val && DFS(A.left,B.left) && DFS(A.right,B.right);
    }


}
