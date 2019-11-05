package homework.two;


import java.util.Scanner;

public class Main33 {

    static class ListNode {

        ListNode() {

        }

        ListNode(String value) {
            this.value = value;
        }

        String value;
        ListNode next;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                sb.append(cur.value);
                sb.append(" ");
                cur = cur.next;
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cases; i++) {
            String[] input = sc.nextLine().split(" ");
            int length = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[input.length - 1]);
            ListNode head = new ListNode();
            ListNode cur = head;
            for (int j = 1; j < input.length - 1; j++) {
                cur.next = new ListNode(input[j]);
                cur = cur.next;
            }
            if (k > 1) {
                ListNode curHead = head;
                for (int times = 0; times + k <= length; times += k) {
                    ListNode node1 = curHead.next;
                    ListNode node2 = node1.next;
                    ListNode node3;
                    for (int j = 0; j < k - 1; j++) {
                        node3 = node2.next;
                        node2.next = node1;
                        node1 = node2;
                        node2 = node3;
                    }
                    ListNode temp = curHead.next;
                    curHead.next.next = node2;
                    curHead.next = node1;
                    curHead = temp;
                }
            }
            System.out.println(head.next);
        }
    }

}
