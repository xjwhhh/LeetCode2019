import java.util.Stack;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        while(l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }
        int extra=0;
        ListNode head=null;
        while(!s1.isEmpty()||!s2.isEmpty()||extra!=0){
            int temp=0;
            if(!s1.isEmpty()){
                temp+=s1.pop();
            }
            if(!s2.isEmpty()){
                temp+=s2.pop();
            }
            temp+=extra;
            if(temp>=10){
                temp-=10;
                extra=1;
            }else{
                extra=0;
            }
            ListNode t=new ListNode(temp);
            t.next=head;
            head=t;

        }
        return head;

    }
}
