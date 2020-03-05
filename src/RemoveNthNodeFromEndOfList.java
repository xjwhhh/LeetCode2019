/**
 * @Author JiaWei Xu
 * @Date 2020-03-05 10:28
 * @Email xjwhhh233@outlook.com
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        ListNode low=head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            low=low.next;
            pre=pre.next;
        }
        pre.next=low.next;
        return dummy.next;

    }
}
