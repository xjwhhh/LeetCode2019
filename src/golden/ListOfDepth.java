package golden;

import sword.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @Author JiaWei Xu
 * @Date 2020-04-23 15:07
 * @Email xjwhhh233@outlook.com
 */
public class ListOfDepth {
    public ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        ArrayList<ListNode> arrayList=new ArrayList<>();
        queue.add(tree);
        while(!queue.isEmpty()){
            int size=queue.size();
            ListNode dummy=new ListNode(0);
            ListNode head=new ListNode(0);
            dummy.next=head;
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                ListNode listNode=new ListNode(curr.val);
                head.next=listNode;
                head=listNode;
                if(curr.left!=null) {
                    queue.add(curr.left);
                }
                if(curr.right!=null) {
                    queue.add(curr.right);
                }
            }
            arrayList.add(dummy.next.next);
        }
        ListNode[] result=new ListNode[arrayList.size()];
        for(int i=0;i<arrayList.size();i++){
            result[i]=arrayList.get(i);
        }
        return result;

    }
}
