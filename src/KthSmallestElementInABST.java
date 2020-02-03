import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-03 12:51
 * @Email xjwhhh233@outlook.com
 */
public class KthSmallestElementInABST {
    Queue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    });
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return queue.peek();
    }

    private void helper(TreeNode root,int k){
        if(root==null){
            return;
        }
        if(queue.size()<k){
            queue.add(root.val);
        }else{
            queue.add(root.val);
            queue.remove();
        }
        helper(root.left,k);
        helper(root.right,k);


    }

    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    //中序遍历，直接排行
    public int kthSmallest1(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }


}
