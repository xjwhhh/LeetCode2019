package golden;

import sword.ListNode;

/**
 * @Author JiaWei Xu
 * @Date 2020-04-20 15:19
 * @Email xjwhhh233@outlook.com
 */
public class SumLists {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode dummy=new ListNode(0);
        ListNode prev=new ListNode(0);
        dummy.next=prev;
        int bit=0;
        while(l1!=null||l2!=null){
            int a=0;
            int b=0;
            if(l1!=null){
                a=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                b=l2.val;
                l2=l2.next;
            }
            int sum=a+b+bit;
            ListNode curr=new ListNode(sum);
            if(sum>=10){
                bit=1;
                curr.val-=10;
            }else{
                bit=0;
            }
            prev.next=curr;
            prev=prev.next;
        }
        if(bit==1){
            ListNode curr=new ListNode(1);
            prev.next=curr;
        }
        return dummy.next.next;
    }
}
