package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-28 12:04
 * @Email xjwhhh233@outlook.com
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val){
            return head.next;
        }
        ListNode pre=head;
        ListNode curr=head.next;
        while(curr!=null){
            if(curr.val==val){
                pre.next=curr.next;
                return head;
            }else{
                pre=pre.next;
                curr=curr.next;
            }
        }
        return head;
    }
}
