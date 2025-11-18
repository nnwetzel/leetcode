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
    // THOUGHT (very concise):
    // Split nodes into two lists by position (odd vs even) in one pass, then attach the even list after the odd list.
    // Time: O(n). Space: O(1).

    // PSEUDOCODE:
    // 1. If list empty or single node, return head.
    // 2. odd = head; even = head.next; evenHead = even.
    // 3. While even and even.next exist:
    //    - odd.next = even.next; odd = odd.next;
    //    - even.next = odd.next; even = even.next;
    // 4. odd.next = evenHead; return head.
    public ListNode oddEvenList(ListNode head) {
        // base cases
        if (head == null || head.next == null) return head;

        // start pointers for odd and even lists
        ListNode odd = head;                // first node (position 1)
        ListNode even = head.next;          // second node (position 2)
        ListNode evenHead = even;           // remember head of even list

        // rewire nodes: odd skips one to next odd, even skips one to next even
        while (even != null && even.next != null) {
            odd.next = even.next;           // link current odd to next odd
            odd = odd.next;                 // advance odd

            even.next = odd.next;           // link current even to next even
            even = even.next;               // advance even
        }

        // attach even list after odd list
        odd.next = evenHead;
        return head;
    }
}