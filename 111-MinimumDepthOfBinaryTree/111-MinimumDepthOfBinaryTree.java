// Last updated: 28/07/2026, 15:44:24
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // If the left subtree is empty, we must find the min depth of the right subtree
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        
        // If the right subtree is empty, we must find the min depth of the left subtree
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        
        // If both subtrees exist, take the minimum of the two
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}