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
        // Recursive approach - O(n + m) time, O(n + m) space (call stack)
        // Pseudocode:
        // 1. Base cases: if one list is null, return the other
        // 2. Compare current nodes of both lists
        // 3. Choose smaller node and recursively merge remaining lists
        // 4. Return the chosen node as head of merged portion
        
        // Base cases: if one list is empty, return the other
        // This automatically adds all remaining nodes to the end of merged list
        if (list1 == null) {
            return list2;  // All remaining nodes in list2 are already sorted
        }
        else if (list2 == null) {
            return list1;  // All remaining nodes in list1 are already sorted
        }
        // Choose smaller value and recursively merge rest
        else if (list1.val < list2.val) {
            // list1 has smaller value, so it goes first in merged list
            // Set list1.next to the result of merging list1's remaining nodes with list2
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;  // Return list1 as the head of this merged portion
        }
        else {
            // list2 has smaller/equal value, so it goes first in merged list
            // Set list2.next to the result of merging list1 with list2's remaining nodes
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;  // Return list2 as the head of this merged portion
        }
    }
}

/* ITERATIVE SOLUTION (for reference):
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    
    while (list1 != null && list2 != null) {
        if (list1.val <= list2.val) {
            current.next = list1;
            list1 = list1.next;
        } else {
            current.next = list2;
            list2 = list2.next;
        }
        current = current.next;
    }
    
    current.next = (list1 != null) ? list1 : list2;
    return dummy.next;
}
*/