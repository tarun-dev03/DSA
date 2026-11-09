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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // Pass both children to your helper method to compare them
        return check(root.left, root.right);
    }
    
    public boolean check(TreeNode left, TreeNode right) {
        // Base case: if both are null, they match
        if (left == null && right == null) {
            return true;
        }
        // If only one is null, they don't match
        if (left == null || right == null) {
            return false;
        }
        
        // Check if current values match AND their outer/inner children match
        return (left.val == right.val) 
            && check(left.left, right.right) 
            && check(left.right, right.left);
    }
}