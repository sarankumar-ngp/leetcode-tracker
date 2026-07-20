// Last updated: 20/07/2026, 14:56:59
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
17    public int minDepth(TreeNode root) {
18        if (root == null) {
19            return 0;
20        }
21        
22        // If the left subtree is empty, we must find the min depth of the right subtree
23        if (root.left == null) {
24            return minDepth(root.right) + 1;
25        }
26        
27        // If the right subtree is empty, we must find the min depth of the left subtree
28        if (root.right == null) {
29            return minDepth(root.left) + 1;
30        }
31        
32        // If both subtrees exist, take the minimum of the two
33        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
34    }
35}