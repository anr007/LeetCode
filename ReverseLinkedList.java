/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

// Iterative Solution
class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {

            next = curr.next; // save the next node link
            curr.next = prev; // reverse the existing link
            prev = curr; // update previous node
            curr = next; // move to the next node

        }

        head = prev; // finally assign the last node as head

        return head;

    }
}

// Recursive Solution
class Solution {

    private ListNode reverse(ListNode head, ListNode prev) {

        if (head == null) {
            return prev;
        }

        ListNode temp = head.next;
        head.next = prev;
        return reverse(temp, head);
    }

    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }
}