/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        // THOUGHT PROCESS:
        // Reorder list by taking nodes from front and back alternately.
        // Do this in three steps: find middle, reverse second half, weave halves.
        // Time O(n) Space O(1)
        //
        // PSEUDOCODE:
        // 1. Find middle of list using slow and fast pointers
        // 2. Reverse the second half of the list
        // 3. Merge nodes by alternating from first half and reversed second half
        // 4. Finish when second half is exhausted

        if (head == null || head.next == null) return;

        // Find the middle (end of first half)
        // Use slow and fast so slow ends at middle for odd/even length
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half starting after slow
        ListNode second = slow.next;
        slow.next = null; // Cut first half
        ListNode prev = null;
        while (second != null) {
            ListNode nextTmp = second.next;
            second.next = prev; // Reverse link
            prev = second;      // Move prev forward
            second = nextTmp;   // Move second forward
        }

        // Merge first half (head) and reversed second half (prev)
        ListNode first = head;
        second = prev; // Head of reversed second half
        while (second != null) {
            // Save next pointers
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            // Place node from second after node from first
            first.next = second;
            // Then link that node to the next original first-half node
            second.next = tmp1;

            // Advance pointers to continue weaving
            first = tmp1;
            second = tmp2;
        }
    }
}