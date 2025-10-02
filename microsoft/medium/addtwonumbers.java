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
        // Elementary school addition: add digits from right to left
        // Example: [2,4,3] + [5,6,4] = 342 + 465 = 807 → [7,0,8]
        
        // Dummy head simplifies list building - return tempHead.next at end
        ListNode tempHead = new ListNode(0);
        
        // Current tracks where to add next digit
        ListNode current = tempHead;
        int carry = 0;

        // Process all digits and any remaining carry
        while (l1 != null || l2 != null || carry > 0) {
            // Get digits (0 if list exhausted)
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            // Add digits plus carry: 2 + 5 + 0 = 7, then 4 + 6 + 0 = 10, etc.
            int total = digit1 + digit2 + carry;

            // Extract carry and digit to store
            carry = total / 10;        // 10 → carry = 1
            int digit = total % 10;    // 10 → digit = 0
            
            // Add new node and move current forward
            current.next = new ListNode(digit);
            current = current.next;

            // Move to next digits
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        // Skip dummy head
        return tempHead.next;
    }
}