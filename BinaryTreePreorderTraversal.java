/* Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively? */

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

// Recursive Solution
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> p = new ArrayList<Integer>();

        if (root != null) {

            p.add(root.val);

            p.addAll(preorderTraversal(root.left));

            p.addAll(preorderTraversal(root.right));

        }

        return p;

    }
}

// Iterative Solution
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> p = new ArrayList<Integer>();

        Stack<TreeNode> s = new Stack<>();

        s.push(root);

        while (!s.empty()) {

            TreeNode n = s.pop();

            if (n != null) {
                p.add(n.val);
                // As stack is LIFO we should push left after right
                // to correctly traverse left node
                s.push(n.right);
                s.push(n.left);
            }

        }

        return p;

    }
}
