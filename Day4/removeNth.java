public class removeNth {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast n + 1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers together
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove nth node from the end
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {

        // Linked List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;

        head = removeNthFromEnd(head, n);

        // Print result
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}