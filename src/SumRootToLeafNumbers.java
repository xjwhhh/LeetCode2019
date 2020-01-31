/**
 * @Author JiaWei Xu
 * @Date 2020-01-31 13:30
 * @Email xjwhhh233@outlook.com
 */
public class SumRootToLeafNumbers {
    int result=0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root,int temp){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            result+=(temp*10+root.val);
            return;
        }
        helper(root.left,temp*10+root.val);
        helper(root.right,temp*10+root.val);

    }
}
