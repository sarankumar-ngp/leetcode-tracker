// Last updated: 20/07/2026, 14:57:51
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public boolean hasPathSum(TreeNode root, int targetSum) {
18        // Base case: if the tree is empty, there is no path
19        if (root == null) {
20            return false;
21        }
22        
23        // Check if it's a leaf node and if its value matches the remaining targetSum
24        if (root.left == null && root.right == null) {
25            return root.val == targetSum;
26        }
27        
28        // Recursively check the left and right subtrees with the updated targetSum
29        int remainingSum = targetSum - root.val;
30        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
31    }
32}