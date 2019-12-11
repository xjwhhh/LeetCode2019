public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int i=1;
        ListNode curr=head;
        ListNode pre=null;
        while(i<m&&curr!=null){
            pre=curr;
            curr=curr.next;
            i++;
        }
        ListNode tail=curr;
        ListNode con=pre;
        while(i<=n&&curr!=null){
            ListNode temp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
            i++;
        }

        if(con!=null){
            con.next=pre;
        }else{
            head=pre;
        }
        tail.next=curr;

        return head;

    }

    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }


    //递归
    ListNode reverseBetween1(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween1(head.next, m - 1, n - 1);
        return head;
    }

}
