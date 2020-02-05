import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-03 14:07
 * @Email xjwhhh233@outlook.com
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder=new StringBuilder();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            if(temp==null){
                stringBuilder.append("null,");
            }else{
                stringBuilder.append(temp.val).append(",");
                System.out.println(temp.val);
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        stringBuilder.substring(0,stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array=data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(array));
        Queue<TreeNode> treeNodeQueue=new LinkedList<>();
        if(queue.size()==0){
            return null;
        }
        String first=queue.poll();
        if(first.equals("null")){
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(first));
        treeNodeQueue.add(root);
        while(!treeNodeQueue.isEmpty()){
            TreeNode tempNode=treeNodeQueue.poll();
            if(tempNode!=null) {
                String temp = queue.poll();
                if (temp.equals("null")) {
                    tempNode.left = null;
                } else {
                    tempNode.left=new TreeNode(Integer.parseInt(temp));
                    treeNodeQueue.add(tempNode.left);
                }
                 temp = queue.poll();
                if (temp.equals("null")) {
                    tempNode.right = null;
                } else {
                    tempNode.right=new TreeNode(Integer.parseInt(temp));
                    treeNodeQueue.add(tempNode.right);
                }

            }
        }
        return root;
    }

    public TreeNode deserialize1(String data) {
        String[] array = data.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String s : array) {
            queue.add(s);
        }
        return deserializeByPreProcess(queue);
    }
    private TreeNode deserializeByPreProcess(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeByPreProcess(queue);
        node.right = deserializeByPreProcess(queue);
        return node;
    }


}
