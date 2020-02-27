package sword;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-27 16:00
 * @Email xjwhhh233@outlook.com
 */
public class ZeroSix {
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        while(head!=null){
            arrayList.add(head.val);
            head=head.next;
        }
        Collections.reverse(arrayList);
        int[] result=new int[arrayList.size()];
        for(int i=0;i<arrayList.size();i++){
            result[i]=arrayList.get(i);

        }
        return result;
    }

    ArrayList<Integer> tmp = new ArrayList<Integer>();
    public int[] reversePrint1(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = tmp.get(i);
        return res;
    }
    void recur(ListNode head) {
        if(head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }
}
