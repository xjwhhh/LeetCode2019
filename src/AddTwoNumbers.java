public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode result2 = result;

        int extra = 0;
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val + extra;
            if (temp >= 10) {
                temp -= 10;
                extra = 1;
            } else {
                extra = 0;
            }
            ListNode t = new ListNode(temp);
            result.next = t;
            result = t;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 == null && l2 != null) {
            int temp = l2.val + extra;
            if (temp >= 10) {
                temp -= 10;
                extra = 1;
            } else {
                extra = 0;
            }
            ListNode t = new ListNode(temp);
            result.next = t;
            result = t;
            l2 = l2.next;
        }
        while (l2 == null && l1 != null) {
            int temp = l1.val + extra;
            if (temp >= 10) {
                temp -= 10;
                extra = 1;
            } else {
                extra = 0;
            }
            ListNode t = new ListNode(temp);
            result.next = t;
            result = t;
            l1 = l1.next;
        }
        if (extra == 1) {
            result.next = new ListNode(1);
        }
        return result2.next;


    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
