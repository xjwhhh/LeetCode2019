/**
 * @Author JiaWei Xu
 * @Date 2020-03-06 12:46
 * @Email xjwhhh233@outlook.com
 */
public class InsertIntoASortedCircularLinkedList {
    public Node insert(Node head, int insertVal) {
        if(head==null){
            Node result=new Node(insertVal);
            result.next=result;
            return result;
        }
        Node pre=head;
        Node curr=head.next;
        boolean toInsert=false;
        do{
            if(pre.val<=insertVal&&insertVal<=curr.val){
                toInsert=true;
            } else if(pre.val>curr.val){
                if(insertVal>=pre.val||insertVal<=curr.val){
                    toInsert=true;
                }
            }
            if(toInsert){
                Node newNode=new Node(insertVal);
                newNode.next=curr;
                pre.next=newNode;
                return head;
            }
            pre=pre.next;
            curr=curr.next;
        }while(pre!=head);

            Node newNode=new Node(insertVal);
            newNode.next=curr;
            pre.next=newNode;

        return head;
    }
}
