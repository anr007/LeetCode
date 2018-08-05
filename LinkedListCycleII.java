/* Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
 */

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Floyd's Algorithm: distance from head and where the
                // two pointers meet is the same i.e start of the loop.
                ListNode start = head;

                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }

                return slow;
            }
        }

        return null;
    }
}