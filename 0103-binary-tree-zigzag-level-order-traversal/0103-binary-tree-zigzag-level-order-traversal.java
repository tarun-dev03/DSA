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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        boolean reverse = false;
        while(!dq.isEmpty()){
            int levelSize = dq.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i = 0; i < levelSize;i++){
                if(!reverse){
                    TreeNode current = dq.pollFirst();
                    currentLevel.add(current.val);
                    if(current.left != null) dq.addLast(current.left);
                    if(current.right != null) dq.addLast(current.right);
                }
                if(reverse){
                    TreeNode current = dq.pollLast();
                    currentLevel.add(current.val);
                    if(current.right != null) dq.addFirst(current.right);
                    if(current.left != null) dq.addFirst(current.left);
                }
            }
        
        reverse = !reverse;
        result.add(currentLevel);
        }
        return result;
    }
    
}