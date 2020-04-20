package golden;

import sword.ListNode;

/**
 * @Author JiaWei Xu
 * @Date 2020-04-20 15:36
 * @Email xjwhhh233@outlook.com
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode second=slow.next;
        ListNode curr=reverse(second);

        while(curr!=null){
//            System.out.println(curr.val);
//            System.out.println(head.val);

            if(curr.val!=head.val){
                return false;
            }
            curr=curr.next;
            head=head.next;
        }
        return true;

    }

    private ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
