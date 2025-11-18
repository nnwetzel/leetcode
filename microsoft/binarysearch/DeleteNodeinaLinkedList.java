/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // THOUGHT PROCESS:
        // We only have access to the node to delete, not the head.
        // Copy the next node's value into this node and bypass the next node.
        //
        // PSEUDOCODE:
        // 1. Set current node value to next node value
        // 2. Set current node next to next node next
        // 3. The next node is effectively removed

        node.val = node.next.val;
        node.next = node.next.next;
    }
}