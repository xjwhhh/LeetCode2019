import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-08 18:55
 * @Email xjwhhh233@outlook.com
 */
public class MaximumProductOfSplittedBinaryTree {
    double result=0;
    double rootSum=0;
    public int maxProduct(TreeNode root) {
        if(root==null){
            return 0;
        }
        rootSum=sum(root);
        dfs(root);
        return (int)(result%1000000007);
    }

    private double sum(TreeNode root){
        if(root==null){
            return 0;
        }
        return root.val+sum(root.left)+sum(root.right);
    }

    private double dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        double leftSum=dfs(root.left);
        double rightSum=dfs(root.right);
//        System.out.println(root.val);
//        System.out.println(leftSum);
//        System.out.println(rightSum);
//        System.out.println("kjjj");
//        int temp=Math.max((rootSum-leftSum)*leftSum,(rootSum-rightSum)*rightSum);
        double sum=root.val+leftSum+rightSum;
        result=Math.max(result,(rootSum-sum)*sum);
        return sum;
    }
}
