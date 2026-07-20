// Last updated: 20/07/2026, 14:55:59
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
17    public boolean isBalanced(TreeNode root) {
18        return checkHeight(root) != -1;
19    }
20
21    private int checkHeight(TreeNode node) {
22        if (node == null) {
23            return 0;
24        }
25
26        int leftHeight = checkHeight(node.left);
27        if (leftHeight == -1) {
28            return -1;
29        }
30
31        int rightHeight = checkHeight(node.right);
32        if (rightHeight == -1) {
33            return -1;
34        }
35
36        if (Math.abs(leftHeight - rightHeight) > 1) {
37            return -1;
38        }
39
40        return Math.max(leftHeight, rightHeight) + 1;
41    }
42}