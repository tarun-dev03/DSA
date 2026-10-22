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
    private int maxDiameter = 0 ;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        height(root);
        return maxDiameter -1;
    }
    public int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftH = height(node.left);
        int rightH = height(node.right);
        int dia = leftH + rightH + 1;
        maxDiameter = Math.max(maxDiameter,dia);
        return Math.max(rightH,leftH) + 1;

    }
}