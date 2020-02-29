package sword;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-29 10:54
 * @Email xjwhhh233@outlook.com
 */
public class CopyRandomList {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map=new HashMap<>();
        Node p=head;
        while(p!=null){
            map.put(p,new Node(p.val));
            p=p.next;
        }
        p=head;
        while(p!=null){
            map.get(p).next=map.get(p.next);
            map.get(p).random=map.get(p.random);
            p=p.next;
        }
        return map.get(head);


    }
}
