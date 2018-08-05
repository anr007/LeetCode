/* Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass? */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

// The first pointer advances the list by n+1n+1 steps from the beginning, while
// the second pointer starts from the beginning of the list. Now, both pointers
// are exactly separated by nn nodes apart. We maintain this constant gap by
// advancing both pointers together until the first pointer arrives past the
// last node. The second pointer will be pointing at the nnth node counting from
// the last. We relink the next pointer of the node referenced by the second
// pointer to point to the node's next next node.

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // definitely the temp node, it will handle many edge cases
        ListNode temp = new ListNode(0);
        ListNode slow = temp, fast = temp;
        slow.next = head;

        // move fast in front so that the gap between slow and fast becomes n
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        // move fast to the end, maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // skip the desired node
        slow.next = slow.next.next;
        return temp.next;

    }
}