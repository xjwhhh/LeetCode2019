package golden;

import sword.ListNode;

import java.util.HashSet;

/**
 * @Author JiaWei Xu
 * @Date 2020-04-20 19:02
 * @Email xjwhhh233@outlook.com
 */
public class LinkedListCycle {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hashSet=new HashSet<>();
        while(head!=null){
            if(hashSet.contains(head)){
                return head;
            }else{
                hashSet.add(head);
                head=head.next;
            }
        }
        return null;

    }
}
