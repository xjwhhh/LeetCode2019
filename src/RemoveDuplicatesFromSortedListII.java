public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode aHead=new ListNode(0);
        aHead.next=head;
        ListNode temp=head;
        ListNode point=aHead;
        while(temp!=null&&temp.next!=null){
            if(temp.val==temp.next.val){
                while(temp.next!=null&&temp.val==temp.next.val){
                    temp=temp.next;
                }
                temp=temp.next;
                point.next=temp;
            }else{
                temp=temp.next;
                point=point.next;
            }

        }
        return aHead.next;

    }
}
