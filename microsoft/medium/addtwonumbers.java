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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Elementary school addition approach - O(max(m,n)) time complexity
        // Intuition: Add digits from right to left with carry propagation
        // Example: [2,4,3] + [5,6,4] represents 342 + 465 = 807 → [7,0,8]
        
        // Dummy head simplifies list building
        ListNode tempHead = new ListNode(0);
        ListNode current = tempHead;
        int carry = 0;

        // Process all digits and remaining carry - O(max(m,n)) iterations
        while (l1 != null || l2 != null || carry > 0) {
            // Get current digits (0 if list exhausted)
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            // Add digits plus carry: 2 + 5 + 0 = 7
            int total = digit1 + digit2 + carry;

            // Extract carry and digit: 7 → carry = 0, digit = 7
            carry = total / 10;
            int digit = total % 10;
            
            // Build result list
            current.next = new ListNode(digit);
            current = current.next;

            // Move to next digits
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        // Return result (skip dummy head)
        return tempHead.next;
    }
}