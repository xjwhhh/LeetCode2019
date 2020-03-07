/**
 * @Author JiaWei Xu
 * @Date 2020-03-07 11:03
 * @Email xjwhhh233@outlook.com
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        int len=getListLen(head);
        System.out.println(len);
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        for(int i=1;i<len;i*=2){
            System.out.println(i);
            ListNode prev = dummy;
            ListNode curr = dummy.next;
            // 循环 n 次
            while (curr != null) {
                ListNode left = curr;
                System.out.println("left:"+left.val);
                ListNode right = split(left, i);
                if(right!=null){
                    System.out.println("right:"+right.val);
                }
                curr = split(right, i);
                prev.next = mergeTwoList(left, right);
                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }
        return dummy.next;
    }

    private ListNode split(ListNode head,int step){
        if(head==null){
            return null;
        }
        for(int i=1;i<step&&head.next!=null;i++){
            head=head.next;
        }
        ListNode next=head.next;
        head.next=null;
        return next;
    }

    private ListNode mergeTwoList(ListNode a,ListNode b){
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while(a!=null&&b!=null){
            if(a.val<b.val){
                curr.next=a;
                a=a.next;
            }else{
                curr.next=b;
                b=b.next;
            }
            curr=curr.next;
        }
        if(a!=null){
            curr.next=a;
        }
        if(b!=null){
            curr.next=b;
        }
        return dummy.next;
    }

    private int getListLen(ListNode head){
        int length=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            length++;
        }
        return length;
    }
}
