// Last updated: 20/07/2026, 15:08:20
1import java.util.ArrayList;
2import java.util.LinkedList;
3import java.util.List;
4import java.util.Stack;
5
6/**
7 * Definition for a binary tree node.
8 * public class TreeNode {
9 *     int val;
10 *     TreeNode left;
11 *     TreeNode right;
12 *     TreeNode() {}
13 *     TreeNode(int val) { this.val = val; }
14 *     TreeNode(int val, TreeNode left, TreeNode right) {
15 *         this.val = val;
16 *         this.left = left;
17 *         this.right = right;
18 *     }
19 * }
20 */
21class Solution {
22    public List<Integer> postorderTraversal(TreeNode root) {
23        LinkedList<Integer> result = new LinkedList<>();
24        if (root == null) {
25            return result;
26        }
27
28        Stack<TreeNode> stack = new Stack<>();
29        stack.push(root);
30
31        while (!stack.isEmpty()) {
32            TreeNode node = stack.pop();
33            // Add to the front of the list to reverse the Root -> Right -> Left order
34            result.addFirst(node.val);
35
36            // Push left child first so right child is processed next (Root -> Right -> Left)
37            if (node.left != null) {
38                stack.push(node.left);
39            }
40            if (node.right != null) {
41                stack.push(node.right);
42            }
43        }
44
45        return result;
46    }
47}