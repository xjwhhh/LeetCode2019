package golden;


/**
 * @Author JiaWei Xu
 * @Date 2020-04-23 14:50
 * @Email xjwhhh233@outlook.com
 */
public class MinimumHeightTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);

    }

    private TreeNode helper(int[] nums,int left,int right){
        if(left==right){
            return new TreeNode(nums[left]);
        }
        if(left>right){
            return null;
        }
        int mid=(right-left)<<1+left;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,left,mid-1);
        root.right=helper(nums,mid+1,right);
        return root;
    }
}
