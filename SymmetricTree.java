/* Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively. */

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

// recursive
class Solution {
    public boolean isSymmetric(TreeNode root) {

        if (root == null)
            return true;

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode l, TreeNode r) {

        if (l == null && r == null)
            return true;
        if (l == null || r == null)
            return false;

        return (l.val == r.val) && helper(l.left, r.right) && helper(l.right, r.left);

    }
}

// iterative
class Solution {
    public boolean isSymmetric(TreeNode root) {

        if (root == null)
            return true;

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty()) {

            TreeNode l = q.poll(), r = q.poll();

            if (l == null && r == null) {
                continue;
            } else {

                if (l == null || r == null)
                    return false;

                if (l.val != r.val)
                    return false;
                // follow same order to check symmetric properties
                q.add(l.left);
                q.add(r.right);
                q.add(l.right);
                q.add(r.left);
            }

        }

        return true;
    }

}