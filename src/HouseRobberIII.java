public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res=myRob(root);
        return Math.max(res[0],res[1]);

    }
    //res[0]为不包括根节点的最大值，res[1]为包括根节点的最大值
    private int[] myRob(TreeNode root){
        int[] res=new int[2];
        if(root==null){
            return res;
        }
        int[] left=myRob(root.left);
        int[] right=myRob(root.right);

        //不包含根节点，最大值为两个子树的最大值之和
        res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        //包含根节点，最大值为两个子树不包含根节点的最大值加上根节点的值
        res[1]=left[0]+right[0]+root.val;
        return res;


    }
}
