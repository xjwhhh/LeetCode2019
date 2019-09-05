import java.util.List;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0){
            return head;
        }
        ListNode start=head;
        int len=0;
        while(start!=null){
            start=start.next;
            len++;
        }
        if(len==0||k%len==0){
            return head;
        }
        k=k%len;
        int count=2;
        ListNode curr=head.next;
        ListNode prev=head;
        while(count<len-k+1){
            curr=curr.next;
            prev=prev.next;
        }
        ListNode newHead=curr;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=head;
        prev.next=null;
        return newHead;
    }

    //先连成环再断开
    public ListNode rotateRight1(ListNode head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for(n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }
}
