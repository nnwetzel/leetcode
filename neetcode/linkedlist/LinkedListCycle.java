/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // THOUGHT PROCESS:
        // Use two pointers at different speeds to detect a cycle
        // Slow moves one step, fast moves two steps
        // If there is a cycle the fast pointer will eventually lap the slow pointer
        // Time O(n) Space O(1)
        //
        // PSEUDOCODE:
        // 1. Put slow and fast at head
        // 2. While fast and fast.next are not null
        //   - Advance slow by one, fast by two
        //   - If slow and fast point to the same node return true
        // 3. Return false

        // slow moves one step at a time
        ListNode slow = head;
        // fast moves two steps at a time
        ListNode fast = head;

        // Fast will meet null eventually if there is no cycle
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // advance fast two nodes
            slow = slow.next;      // advance slow one node

            // If pointers meet there is a cycle
            if (slow == fast) return true;
        }

        // fast reached the end, no cycle found
        return false;
    }
}