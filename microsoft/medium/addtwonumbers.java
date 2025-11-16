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
    // Treat the input lists as numbers written backwards and add them the same way you do on paper:
    // add the least-significant digits first, carry any overflow to the next position, and write
    // each result digit into a new list. A dummy head makes appending digits easy.
    
    // PSEUDOCODE:
    // 1. Create a dummy head and set carry to zero.
    // 2. While either list has nodes or carry does not equal 0:
    //    - Sum the current digits and carry.
    //    - Append sum mod 10 to result and update carry = sum / 10.
    //    - Advance input lists if present.
    // 3. Return result after the dummy head.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Intuition: Add digits from right to left with carry propagation

        // dummy head simplifies list building for result
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        // process all digits and remaining carry
        while (l1 != null || l2 != null || carry != 0) {
            // get current digits (0 if list exhausted because we treat missing digits as 0)
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            // add digits plus carry
            int total = digit1 + digit2 + carry;

            // calculate new carry and digit to add to result
            carry = total / 10;       // ex: if sum is 10, carry is 1
            int digit = total % 10;   // ex: if sum is 10, digit is 0

            // build result list
            curr.next = new ListNode(digit);
            curr = curr.next;

            // advance to next digits
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        // skip dummy head
        return dummy.next;
    }
}