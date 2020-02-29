package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-29 10:55
 * @Email xjwhhh233@outlook.com
 */
class Node {
    int val;
    Node next;
    Node random;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
