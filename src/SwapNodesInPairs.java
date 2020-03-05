/**
 * @Author JiaWei Xu
 * @Date 2020-03-04 18:17
 * @Email xjwhhh233@outlook.com
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode curr=head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        while(curr!=null&&curr.next!=null){
            ListNode first=curr;
            ListNode second=curr.next;
            ListNode next=second.next;
            pre.next=second;
            second.next=first;
            first.next=next;
            pre=first;
            curr=next;
        }
        return dummy.next;

    }
}
