import java.util.*;

/**
 * @Author JiaWei Xu
 * @Date 2020-01-31 14:14
 * @Email xjwhhh233@outlook.com
 */
public class BinarySearchTreeIterator {

    List<Integer> list=new ArrayList<>();
    int index=0;

    public BinarySearchTreeIterator(TreeNode root) {
        helper(root);
//        Collections.sort(list);
    }

    private void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        list.add(root.val);

        helper(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        if(index<list.size()){
            return list.get(index);
        }
        return 0;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index<list.size();
    }
}
