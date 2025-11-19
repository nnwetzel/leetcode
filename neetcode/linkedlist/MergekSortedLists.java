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
    public ListNode mergeKLists(ListNode[] lists) {
        // THOUGHT PROCESS:
        // Merge k sorted lists by repeatedly merging pairs (divide & conquer).
        // Each pass halves the number of lists, yielding O(N log k) time.
        // Time O(N log k) Space O(1) extra.
        //
        // PSEUDOCODE:
        // 1. If no lists return null
        // 2. While more than one list remains:
        //   - Merge lists in pairs (each for-loop cuts the list count roughly in half)
        //   - Replace lists with merged results (convert merged results back to array)
        // 3. Return the remaining merged list (lists[0])

        if (lists == null || lists.length == 0) return null;

        while (lists.length > 1) {
            List<ListNode> mergedLists = new ArrayList<>();

            // Merge lists in pairs; each pass reduces the number of lists by ~half
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                // l2 is the second list in the pair; it may be null when there's an odd number of lists
                ListNode l2 = (i + 1) < lists.length ? lists[i + 1] : null;
                mergedLists.add(mergeTwo(l1, l2));
            }

            // Convert merged results to array for the next pass
            lists = mergedLists.toArray(new ListNode[0]);
        }

        // The single remaining element is the fully merged list
        return lists[0];
    }

    // Merge two sorted lists iteratively
    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Attach the smaller node each step
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Append the remaining nodes (one list may be non-empty)
        if (l1 != null) {
            tail.next = l1;
        }
        else {
            tail.next = l2;
        }

        return dummy.next;
    }
}