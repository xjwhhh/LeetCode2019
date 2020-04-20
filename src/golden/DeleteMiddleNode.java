package golden;

import sword.ListNode;

/**
 * @Author JiaWei Xu
 * @Date 2020-04-20 11:52
 * @Email xjwhhh233@outlook.com
 */
public class DeleteMiddleNode {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
