/**
 * @Author JiaWei Xu
 * @Date 2020-03-03 16:39
 * @Email xjwhhh233@outlook.com
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==0||k==1){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode left=head;
        ListNode next=head;
        ListNode curr=dummy;
        while(curr.next!=null){
            //得到k个节点
            for(int i=0;i<k&&curr!=null;i++){
                curr=curr.next;
            }
            if(curr==null){
                break;
            }
            left=pre.next;
            next=curr.next;
            //从尾部断开与原链表的连接
            curr.next=null;
            //翻转，重新连接
            pre.next=reverse(left);
            left.next=next;

            //重置位置
            pre=left;
            curr=left;
        }
        return dummy.next;


    }

    //用pre将之前的node保存起来
    private ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode curr=head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;

    }
}
