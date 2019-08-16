public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        int mid=nums.length/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=help(nums,0,mid-1);
        root.right=help(nums,mid+1,nums.length-1);
        return root;


    }

    public TreeNode help(int[] nums,int left,int right){
        if(left>right){
            return null;
        }
        if(left==right){
            return new TreeNode(nums[left]);
        }
        int mid=(right-left)/2+left;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=help(nums,left,mid-1);
        root.right=help(nums,mid+1,right);
        return root;
    }
}
