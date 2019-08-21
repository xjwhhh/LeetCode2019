import java.util.HashSet;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        HashSet<ListNode> set=new HashSet<>();
        set.add(head);
        while(head.next!=null){
            head=head.next;
            if(set.contains(head)){
                return true;
            }else {
                set.add(head);
            }
        }
        return false;

    }

    //双指针 如果有环，快指针一定会追上慢指针
    public static boolean hasCycle1(ListNode head) {
        if(head==null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        for(;slow!=fast;slow = slow.next,fast = fast.next.next)
            if(fast==null || fast.next ==null) return false;
        return true;
    }
}
