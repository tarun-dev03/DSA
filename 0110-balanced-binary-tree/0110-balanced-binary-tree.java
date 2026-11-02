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
 *        TreeNode right = (main.right);
        main = Math.max(left,right)+1;
        height = max;

        return true;
    }
}    }
 * }
 */
class Solution {

    public boolean isBalanced(TreeNode root) {
        return findBalance(root) != -1;
    }

    public int findBalance(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int left = findBalance(node.left);
        int right = findBalance(node.right);

        if (left == -1 || right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}