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
    public ListNode reverseList(ListNode head) {
        // THOUGHT PROCESS:
        // Iterative three-pointer approach - O(n) time, O(1) space
        
        // PSEUDOCODE:
        // 1. Use three pointers: prev (null), curr (head), next (temp)
        // 2. For each node, reverse the link to point backward
        // 3. Move all pointers forward one step
        // 4. Continue until curr reaches null, return prev as new head
        // Three pointer means we keep prev current and nextTemp pointers so we can reverse the current node's link
        // without losing access to the remainder of the list
        
        ListNode prev = null;    // Previous node (starts as null)
        ListNode curr = head;    // Current node being processed
        
        while (curr != null) {
            // Save next node before we lose the reference
            ListNode nextTemp = curr.next;
            
            // Reverse the link: point current node back to previous
            curr.next = prev;
            
            // Move pointers forward for next iteration
            prev = curr;         // Previous becomes current
            curr = nextTemp;     // Current becomes next
        }
        
        // prev is now the new head of reversed list
        return prev;
    }
}