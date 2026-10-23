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
    public void flatten(TreeNode root) {
        TreeNode current = root;
        
        while (current != null) {
            if (current.left != null) {
                // Find the rightmost node in the left subtree
                TreeNode temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                
                // Wire the original right subtree to the bottom of the left subtree
                temp.right = current.right;
                
                // Move left subtree to the right, and set left to null
                current.right = current.left;
                current.left = null;
            }
            // Move to the next node down the right chain
            current = current.right;
        }
    }
}