package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-28 12:39
 * @Email xjwhhh233@outlook.com
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode curr=head.next;
        ListNode pre=head;
        pre.next=null;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }
        return pre;


    }
}
