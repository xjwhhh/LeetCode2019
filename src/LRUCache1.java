import java.util.HashMap;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-03 15:46
 * @Email xjwhhh233@outlook.com
 */
public class LRUCache1 {

    class Node{
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }

    class DoubleList{
        private Node head,tail;
        private int size;

        DoubleList(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addFirst(Node x){
            x.next=head.next;
            head.next.prev=x;
            head.next=x;
            x.prev=head;
            size++;
        }

        public void remove(Node x){
            x.prev.next=x.next;
            x.next.prev=x.prev;
            size--;
        }

        public Node removeLast(){
            if (tail.prev == head) {
                return null;
            }
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }

    HashMap<Integer,Node> hashMap;
    DoubleList doubleList;
    int size;

    public LRUCache1(int capacity) {
        hashMap=new HashMap<>();
        doubleList=new DoubleList();
        size=capacity;

    }



    public int get(int key) {
        if(hashMap.containsKey(key)){
            int val=hashMap.get(key).val;
            put(key,val);

            return hashMap.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node=new Node(key,value);
        if(hashMap.containsKey(key)){
            //删除原先的节点，而不是新构造的node
            doubleList.remove(hashMap.get(key));
            hashMap.put(key,node);
            doubleList.addFirst(node);
        }else{
            if(hashMap.size()<size){
                hashMap.put(key,node);
                doubleList.addFirst(node);
            }else{
                int removeKey=doubleList.removeLast().key;
                hashMap.remove(removeKey);
                doubleList.addFirst(node);
                hashMap.put(key,node);
            }
        }

    }
}
