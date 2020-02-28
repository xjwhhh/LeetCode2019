package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-28 12:27
 * @Email xjwhhh233@outlook.com
 */
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode pre=head;
        ListNode curr=head;
        for(int i=0;i<k;i++){
            if(curr!=null){
                curr=curr.next;
            }else{
                return null;
            }
        }
        while(curr.next!=null){
            curr=curr.next;
            pre=pre.next;
        }
        return pre;

    }
}
