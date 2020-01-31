/**
 * @Author JiaWei Xu
 * @Date 2020-01-31 12:10
 * @Email xjwhhh233@outlook.com
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode mid=findMid(head);
        TreeNode root=new TreeNode(mid.val);
        if(mid==head){
            return root;
        }
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(mid.next);
        return root;
    }

    private ListNode findMid(ListNode head){
        if(head==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        ListNode pre=null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(pre!=null){
            pre.next=null;
        }
        return slow;
    }
}
