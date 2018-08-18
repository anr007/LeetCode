/* Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

// BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        List<List<Integer>> lvl = new ArrayList<List<Integer>>();

        if (root == null)
            return lvl;

        // offer is same as add but without exceptions
        queue.offer(root);

        while (!queue.isEmpty()) {

            // gives the no.of elements inserted in previous iteration (ie. level)
            int count = queue.size();

            List<Integer> subList = new ArrayList<Integer>();

            for (int i = 0; i < count; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
                subList.add(cur.val);
            }

            lvl.add(subList);
        }

        return lvl;

    }
}

// DFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> lvl = new ArrayList<>();

        DFS(root, lvl, 0);

        return lvl;

    }

    private void DFS(TreeNode cur, List<List<Integer>> lvl, int height) {
        if (cur == null)
            return;

        if (height >= lvl.size())
            lvl.add(new ArrayList<Integer>());

        // height index identifies nodes belonging to same level
        // so, they are added into the same sublist
        lvl.get(height).add(cur.val);
        DFS(cur.left, lvl, height + 1);
        DFS(cur.right, lvl, height + 1);

    }
}