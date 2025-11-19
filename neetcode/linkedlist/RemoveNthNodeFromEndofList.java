class Solution {
    // THOUGHT PROCESS:
    // Use fast/slow pointers with a dummy to handle edge cases.
    // Move fast n+1 steps, then move both until fast is null (end of list).
    // Now slow.next is the node to remove.

    // PSEUDOCODE:
    // 1. Create dummy -> head; set slow = fast = dummy.
    // 2. Advance fast n + 1 steps.
    // 3. Advance slow and fast until fast is null.
    // 4. Remove slow.next and return dummy.next.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to simplify edge cases (like removing the head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast n + 1 steps so the gap is n
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast hits the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow.next is the node to delete
        slow.next = slow.next.next;

        return dummy.next;
    }
}