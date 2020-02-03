import java.util.ArrayList;
import java.util.List;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-03 13:44
 * @Email xjwhhh233@outlook.com
 */
public class BinaryTreePaths {

    List<String> list=new ArrayList<>();


    public List<String> binaryTreePaths(TreeNode root) {
        helper(root,new StringBuilder());
        return list;
    }

    private void helper(TreeNode root,StringBuilder stringBuilder){
        if(root.left==null&&root.right==null){
            String path=stringBuilder.toString();
            if(path.length()!=0){
                path=path.substring(0,path.length()-2);
                System.out.println(path);
                list.add(path);
            }
            return;
        }
        stringBuilder.append(root.val).append("->");
        if(root.left!=null) {
            helper(root.left, new StringBuilder(stringBuilder));
        }
        if(root.right!=null) {
            helper(root.right, new StringBuilder(stringBuilder));
        }
    }
}
