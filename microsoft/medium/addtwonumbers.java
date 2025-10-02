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
        // Example: [2,4,3] + [5,6,4] represents 342 + 465 = 807
        
        // tempHead: dummy node to avoid checking "is this the first node?"
        // Without it, we'd need special logic for creating the very first node
        ListNode tempHead = new ListNode(0);
        
        // current: pointer that moves as we build the result list
        // tempHead stays fixed at the beginning, current does the actual building
        ListNode current = tempHead;
        int carry = 0;

        // Process all digits and any remaining carry
        while (l1 != null || l2 != null || carry > 0) {
            // Get digits (0 if list exhausted)
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            // First iteration: 2 + 5 = 7
            int total = digit1 + digit2 + carry;

            // First iteration: 7 → carry = 0, digit = 7
            carry = total / 10;
            int digit = total % 10;
            
            // Build result: first create [7]
            current.next = new ListNode(digit);
            current = current.next;

            // Move to next digits in input lists
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        // Return [7,0,8] (skip dummy head)
        return tempHead.next;
    }
}