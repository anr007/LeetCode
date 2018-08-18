/* Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively? */

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

// Recursive
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> p = new ArrayList<>();

        if (root != null) {
            p.addAll(postorderTraversal(root.left));
            p.addAll(postorderTraversal(root.right));
            p.add(root.val);

        }

        return p;
    }
}

// Iterative
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        Stack<TreeNode> s = new Stack<>();
        LinkedList<Integer> p = new LinkedList<Integer>();

        if (root != null)
            s.push(root);
        // we will be creating the list from the last node
        // so, LRN -> NRL
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            p.addFirst(cur.val);

            if (cur.left != null) {
                s.push(cur.left);
            }

            if (cur.right != null) {
                s.push(cur.right);
            }
        }

        return p;
    }
}