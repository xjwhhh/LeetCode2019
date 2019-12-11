public class PalindromeLinkedList {
    //wrong
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode fast=head.next;
        ListNode slow=head;
        ListNode pre=null;
        ListNode curr=head;
        while(fast!=null&&fast.next!=null){
            curr=slow;
            fast=fast.next.next;
            slow=slow.next;
            curr.next=pre;
            pre=curr;

        }
        ListNode p1=curr;
        ListNode p2=slow.next;
        if(fast==null){
            p2=slow;
        }
        while(p1!=null){
            System.out.println(p1.val);
            System.out.println(p2.val);
            if(p1.val!=p2.val){
                return false;
            }else{
                p1=p1.next;
                p2=p2.next;
            }
        }

        return true;



    }

    public boolean isPalindrome1(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if(fast != null) {
            slow = slow.next;
        }
        while(pre != null && slow != null) {
            if(pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

}
