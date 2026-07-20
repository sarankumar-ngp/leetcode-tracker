// Last updated: 20/07/2026, 15:07:04
1import java.util.ArrayList;
2import java.util.List;
3import java.util.Stack;
4
5class Solution {
6    public List<Integer> preorderTraversal(TreeNode root) {
7        List<Integer> result = new ArrayList<>();
8        if (root == null) {
9            return result;
10        }
11
12        Stack<TreeNode> stack = new Stack<>();
13        stack.push(root);
14
15        while (!stack.isEmpty()) {
16            TreeNode node = stack.pop();
17            result.add(node.val);
18
19            if (node.right != null) {
20                stack.push(node.right);
21            }
22            if (node.left != null) {
23                stack.push(node.left);
24            }
25        }
26
27        return result;
28    }
29}