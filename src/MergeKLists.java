import java.util.LinkedList;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-03 16:06
 * @Email xjwhhh233@outlook.com
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        return merge(lists,0,lists.length-1);

    }

    private ListNode merge(ListNode[] lists,int left, int right){
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode a,ListNode b){
        ListNode head=new ListNode(0);
        ListNode curr=head;
        while(a!=null&&b!=null){
            if(a.val>b.val){
                curr.next=new ListNode(b.val);
                b=b.next;
            }else{
                curr.next=new ListNode(a.val);
                a=a.next;
            }
            curr=curr.next;
        }
        if(a!=null){
            curr.next=a;
        }
        if(b!=null){
            curr.next=b;
        }
        return head.next;
    }
}
