package golden;

import sword.ListNode;

/**
 * @Author JiaWei Xu
 * @Date 2020-04-20 15:13
 * @Email xjwhhh233@outlook.com
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=head;
        head=head.next;
        while(head!=null){
            if(head.val<x){
                prev.next=head.next;
                head.next=dummy.next;
                dummy.next=head;
                head=prev.next;
            }else{
                prev=prev.next;
                head=head.next;
            }
        }
        return dummy.next;

    }

}
