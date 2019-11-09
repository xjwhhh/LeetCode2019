public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Node cur = root;
        Node pre = null;
        while (cur != null) {
            while (pre != null) {
                pre.left.next = pre.right;
                if (pre.next != null)
                    pre.right.next = pre.next.left;
                pre = pre.next;
            }
            pre = cur;
            cur = cur.left;
        }

        return root;
    }
}
