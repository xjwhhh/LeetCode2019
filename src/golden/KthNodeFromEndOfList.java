package golden;

import sword.ListNode;

/**
 * @Author JiaWei Xu
 * @Date 2020-04-20 11:44
 * @Email xjwhhh233@outlook.com
 */
public class KthNodeFromEndOfList {
    public int kthToLast(ListNode head, int k) {
        ListNode first=head;
        ListNode second=head;
        while(second!=null&&k>0){
            second=second.next;
            k--;
        }
        while(second!=null&&second.next!=null){
            second=second.next;
            first=first.next;
        }
        return first.val;

    }
}
