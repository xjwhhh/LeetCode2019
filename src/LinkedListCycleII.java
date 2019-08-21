import java.util.HashSet;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next == null) {
            return null;
        }
        HashSet<ListNode> set=new HashSet<>();
        set.add(head);
        while(head.next!=null){
            head=head.next;
            if(set.contains(head)){
                return head;
            }else {
                set.add(head);
            }
        }
        return null;


    }
}
