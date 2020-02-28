package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-28 12:44
 * @Email xjwhhh233@outlook.com
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode curr=result;
        while(l1!=null&&l2!=null){
            if(l1.val==l2.val){
                ListNode temp1=new ListNode(l1.val);
                ListNode temp2=new ListNode(l2.val);
                curr.next=temp1;
                curr=curr.next;
                curr.next=temp2;
                curr=curr.next;
                l1=l1.next;
                l2=l2.next;
            }else if(l1.val>l2.val){
                curr.next= new ListNode(l2.val);
                curr=curr.next;
                l2=l2.next;
            }else{
                curr.next= new ListNode(l1.val);
                curr=curr.next;
                l1=l1.next;
            }
        }
        if(l1!=null){
            curr.next=l1;
        }
        if(l2!=null){
            curr.next=l2;
        }
        return result.next;



    }
}
