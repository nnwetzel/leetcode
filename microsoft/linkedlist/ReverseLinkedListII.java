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

    // THOUGHT PROCESS:
    // Point prev to the node before left and curr to the first node in the sublist.
    // Repeatedly remove the node after curr and insert it after prev to reverse the sublist.
    // Example: 1->2->3->4->5, left=2, right=4
    //   step1: move 3 -> 1->3->2->4->5
    //   step2: move 4 -> 1->4->3->2->5

    // PSEUDOCODE:
    // 1. Create dummy pointing to head and move prev to just before left
    // 2. Let curr = prev.next (first node in sublist)
    // 3. Repeat (right - left) times:
    //   - remove the node after curr
    //   - insert that node immediately after prev
    // 4. Return node after dummy

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        // move prev to the node just before left
        for (int i = 1; i < left; i++) prev = prev.next;

        // curr points to the first node in sublist to reverse
        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {
            // node to extract and move to front of sublist
            ListNode move = curr.next;
            // remove 'move' from after curr
            curr.next = move.next;
            // link 'move' to current front of sublist
            move.next = prev.next;
            // insert 'move' after prev
            prev.next = move;
        }
        return dummy.next;
    }
}