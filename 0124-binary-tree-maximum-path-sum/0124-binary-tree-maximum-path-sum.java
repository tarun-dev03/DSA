/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findSum(root);
        return max;
    }

    public int findSum(TreeNode main) {
        if (main == null) {
            return 0;
        }

        int left = Math.max(0, findSum(main.left));
        int right = Math.max(0, findSum(main.right));

        int newMax = main.val + right + left;

        max = Math.max(newMax, max);

        return main.val + Math.max(left, right);
    }
}