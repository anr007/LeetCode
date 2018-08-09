/* Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
 */

/* This can be solved by reversing the 2nd half and compare the two halves. Let's start with an example [1, 1, 2, 1].

In the beginning, set two pointers fast and slow starting at the head.

1 -> 1 -> 2 -> 1 -> null 
sf
(1) Move: fast pointer goes to the end, and slow goes to the middle.

1 -> 1 -> 2 -> 1 -> null 
          s          f
(2) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.

1 -> 1    null <- 2 <- 1           
h                      s
(3) Compare: run the two pointers head and slow together and compare.

1 -> 1    null <- 2 <- 1             
     h            s */

/**
 * Definition for singly-linked list. public class ListNode { 
 * int val;
 * ListNode next; 
 * ListNode(int x) { val = x; } }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        ListNode next = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse second half
        while (slow != null) {

            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        slow = prev;

        fast = head;
        while (slow != null) {

            if (fast.val != slow.val) {
                return false;
            }

            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }
}