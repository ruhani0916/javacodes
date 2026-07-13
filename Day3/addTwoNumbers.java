public class addTwoNumbers {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Solution {

        public Node addTwoNumbers(Node head, Node head1) {

            Node dummy = new Node(0);
            Node curr = dummy;

            int carry = 0;

            while (head != null || head1 != null || carry != 0) {

                int sum = carry;

                if (head != null) {
                    sum += head.data;
                    head = head.next;
                }

                if (head1 != null) {
                    sum += head1.data;
                    head1 = head1.next;
                }

                carry = sum / 10;

                curr.next = new Node(sum % 10);
                curr = curr.next;
            }

            return dummy.next;
        }
    }

    public static void main(String[] args) {

        // First number: 342 → 2 -> 4 -> 3
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(3);

        // Second number: 465 → 5 -> 6 -> 4
        Node head1 = new Node(5);
        head1.next = new Node(6);
        head1.next.next = new Node(4);

        Solution solution = new Solution();

        Node result = solution.addTwoNumbers(head, head1);

        System.out.print("Result: ");

        while (result != null) {
            System.out.print(result.data);

            if (result.next != null) {
                System.out.print(" -> ");
            }

            result = result.next;
        }
    }
}