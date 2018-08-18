/* Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively? */

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

// Recursive Solution
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> i = new ArrayList<Integer>();

        if (root != null) {
            i.addAll(inorderTraversal(root.left));
            i.add(root.val);
            i.addAll(inorderTraversal(root.right));
        }

        return i;
    }
}

// Iterative Solution
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> i = new ArrayList<Integer>();

        Stack<TreeNode> s = new Stack<>();

        TreeNode n = root;

        while (n != null || !s.empty()) {

            // Iteratively Push all the left nodes
            while (n != null) {
                s.push(n);
                n = n.left;
            }

            n = s.pop();
            i.add(n.val);
            n = n.right;
        }

        return i;
    }
}