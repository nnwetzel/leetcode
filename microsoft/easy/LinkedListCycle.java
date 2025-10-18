/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // THOUGHT PROCESS:
        // Brute force: Track all visited nodes in HashSet - O(n) time, O(n) space
        // Example: Visit nodes A→B→C→B, when we see B again, cycle detected
        // Pseudocode:
        // 1. Create HashSet to store visited nodes
        // 2. Traverse list:
        //    - If current node already in set: cycle found
        //    - Otherwise: add to set and continue
        // This works but uses O(n) extra space
        
        // HashSet approach - O(n) time, O(n) space
        Set<ListNode> seen = new HashSet<>();
        
        // Traverse the list - O(n) iterations
        while (head != null) {
            // If we've seen this node before, cycle detected
            if (seen.contains(head)) {
                return true;
            }
            
            // Mark this node as visited
            seen.add(head);
            head = head.next;
        }
        
        // Reached end of list (null), no cycle
        return false;
    }
}

/* OPTIMAL SOLUTION (Two Pointers - Floyd's Cycle Detection):
// O(n) time, O(1) space
// Think of fast/slow as runners on a track - fast will lap slow if there's a loop
public boolean hasCycle(ListNode head) {
    // Handle edge cases
    if (head == null || head.next == null) return false;
    
    ListNode slow = head;        // Moves 1 step at a time
    ListNode fast = head.next;   // Moves 2 steps at a time
    
    // Continue until pointers meet or fast reaches end
    while (slow != fast) {  // ← This checks if fast has "lapped" slow
        // If fast reaches end, no cycle exists
        if (fast == null || fast.next == null) return false;
        
        slow = slow.next;        // Move slow by 1
        fast = fast.next.next;   // Move fast by 2
    }
    
    // When we exit the loop, slow == fast, meaning fast caught up to slow
    // This only happens if there's a cycle (fast "lapped" slow)
    return true;  // ← Cycle detected because fast caught slow
}
*/