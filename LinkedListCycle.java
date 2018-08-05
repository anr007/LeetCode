/* Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? */

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */

/*
 * Use two pointers, slow and fast. slow moves step by step. fast moves two
 * steps at time. if the Linked List has a cycle slow and fast will meet at some
 * point.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }
}