// Last updated: 28/07/2026, 15:44:32
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, the trees are structurally identical up to this point
        if (p == null && q == null) {
            return true;
        }
        
        // If only one of the nodes is null, or their values don't match, they aren't the same
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        // Recursively check if the left subtrees and right subtrees match
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}