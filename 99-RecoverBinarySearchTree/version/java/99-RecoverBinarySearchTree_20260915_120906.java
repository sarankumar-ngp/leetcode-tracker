// Last updated: 15/09/2026, 12:09:06
1class Solution {
2
3    TreeNode first = null;
4    TreeNode second = null;
5    TreeNode prev = null;
6
7    public void recoverTree(TreeNode root) {
8
9        inorder(root);
10
11        int temp = first.val;
12        first.val = second.val;
13        second.val = temp;
14    }
15
16    private void inorder(TreeNode root) {
17
18        if (root == null) {
19            return;
20        }
21
22        inorder(root.left);
23
24        if (prev != null && prev.val > root.val) {
25
26            if (first == null) {
27                first = prev;
28            }
29
30            second = root;
31        }
32
33        prev = root;
34
35        inorder(root.right);
36    }
37}