package golden;

import sword.ListNode;

import java.util.HashSet;

/**
 * @Author JiaWei Xu
 * @Date 2020-04-11 20:42
 * @Email xjwhhh233@outlook.com
 */
public class RemoveDuplicateNode {
    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> hashSet=new HashSet<>();
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;

        while(head!=null){
            if(hashSet.contains(head.val)){
                prev.next=head.next;
                head=head.next;
            }else{
                hashSet.add(head.val);
                prev=prev.next;
                head=head.next;
            }
        }
        return dummy.next;

    }
}
