import java.util.HashMap;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-04 12:00
 * @Email xjwhhh233@outlook.com
 */
public class ReOrderList {
    public void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        ListNode low=head;
        ListNode high=head;
        while(high!=null&&high.next!=null){
            high=high.next.next;
            low=low.next;
        }
        //翻转
        System.out.println(low.val);
        ListNode start=reverse(low.next);
        if(start!=null) {
            System.out.println(start.val);
        }
        //断开连接
        low.next=null;
        ListNode left=head;
        //合并
        while(left!=null&&start!=null){
            ListNode lNext=left.next;
            ListNode rNext=start.next;
            left.next=start;
            start.next=lNext;
            left=lNext;
            start=rNext;
        }
    }

    private ListNode reverse(ListNode head){
        if(head==null){
            return null;
        }
        ListNode curr=head;
        ListNode pre=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
}
