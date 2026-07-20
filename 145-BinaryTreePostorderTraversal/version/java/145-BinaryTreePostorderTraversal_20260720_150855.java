// Last updated: 20/07/2026, 15:08:55
1import java.util.ArrayList;
2import java.util.LinkedList;
3import java.util.List;
4import java.util.Stack;
5
6class Solution {
7    public List<Integer> postorderTraversal(TreeNode root) {
8        LinkedList<Integer> result = new LinkedList<>();
9        if (root == null) {
10            return result;
11        }
12
13        Stack<TreeNode> stack = new Stack<>();
14        stack.push(root);
15
16        while (!stack.isEmpty()) {
17            TreeNode node = stack.pop();
18            result.addFirst(node.val);
19
20
21            if (node.left != null) {
22                stack.push(node.left);
23            }
24            if (node.right != null) {
25                stack.push(node.right);
26            }
27        }
28
29        return result;
30    }
31}