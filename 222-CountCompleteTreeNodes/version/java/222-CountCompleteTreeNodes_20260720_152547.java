// Last updated: 20/07/2026, 15:25:47
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
17    public int countNodes(TreeNode root) {
18        if (root == null) {
19            return 0;
20        }
21
22        int leftHeight = getLeftHeight(root);
23        int rightHeight = getRightHeight(root);
24
25        // If the left and right heights are equal, it's a perfect binary tree
26        if (leftHeight == rightHeight) {
27            // (1 << leftHeight) - 1 is equivalent to 2^height - 1
28            return (1 << leftHeight) - 1;
29        }
30
31        // If it's not perfect, recursively count nodes in left and right subtrees
32        return 1 + countNodes(root.left) + countNodes(root.right);
33    }
34
35    private int getLeftHeight(TreeNode node) {
36        int height = 0;
37        while (node != null) {
38            height++;
39            node = node.left;
40        }
41        return height;
42    }
43
44    private int getRightHeight(TreeNode node) {
45        int height = 0;
46        while (node != null) {
47            height++;
48            node = node.right;
49        }
50        return height;
51    }
52}