package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-29 17:56
 * @Email xjwhhh233@outlook.com
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA=headA;
        ListNode tempB=headB;
        while(tempA!=tempB){
            if(tempA!=null) {
                tempA = tempA.next;
            }else{
                tempA=headB;
            }
            if(tempB!=null){
                tempB=tempB.next;
            }else{
                tempB=headA;
            }
        }
        return tempA;

    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;
        ListNode node1 = headA, node2 = headB;
        while (node1 != node2) {
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }
        return node1;
    }

}
