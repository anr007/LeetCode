/* Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed. */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        int count = 0;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        // count the no.of available nodes
        while (count < k && curr != null) {
            curr = curr.next;
            count++;
        }

        curr = head;

        // if the no.of nodes is less than group size k, return as it is
        if (count == k) {

            // reverse current k nodes group
            while (count-- > 0) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // if (k+1) node is available then pass k+1 node as head
            if (next != null)
                head.next = reverseKGroup(next, k);

            // prev is the last node of the original list
            // so, it will be the head of reversed list
            head = prev;

        }

        return head;

    }
}