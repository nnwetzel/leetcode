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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // THOUGHT PROCESS:
        // Merge while walking both lists with two pointers — O(n + m) time, O(1) extra space
        //
        // PSEUDOCODE:
        // 1. Create a dummy node and set tail to it
        // 2. While both lists have nodes (we are going to remove each node as we add it to the merged list)
        //   - Compare current values and append the smaller to tail
        //   - Advance the chosen list and tail
        // 3. Append remaining nodes from the non-empty list
        // 4. Return dummy.next

        // Dummy node simplifies building the result list
        ListNode dummy = new ListNode(0);
        // Tail points to the last node in the merged list
        ListNode tail = dummy;

        // While both lists are non-empty we can compare and merge
        while (list1 != null && list2 != null) {
            // If list1 value is smaller, attach from list1 because smaller values come first in non-decreasing order
            if (list1.val < list2.val) {
                // Attach node from list1
                tail.next = list1;
                // Advance list1
                list1 = list1.next;
            }
            else {
                // Attach node from list2 (ties like can come from either list)
                tail.next = list2;
                // Advance list2
                list2 = list2.next;
            }
            // Advance tail to the newly attached node
            tail = tail.next;
        }

        // Append the remaining nodes from the non-empty list (while loop above ends when one list is empty)
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        // Return head of merged list
        return dummy.next;
    }
}