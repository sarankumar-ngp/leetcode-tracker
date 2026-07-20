// Last updated: 20/07/2026, 15:36:37
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<String> binaryTreePaths(TreeNode root) {
6        List<String> paths = new ArrayList<>();
7        if (root != null) {
8            dfs(root, new StringBuilder(), paths);
9        }
10        return paths;
11    }
12
13    private void dfs(TreeNode node, StringBuilder path, List<String> paths) {
14        int lengthBeforeAppend = path.length();
15        
16        // Append the current node's value
17        path.append(node.val);
18
19        // Check if it's a leaf node
20        if (node.left == null && node.right == null) {
21            paths.add(path.toString());
22        } else {
23            // If not a leaf, add the delimiter and continue exploring children
24            path.append("->");
25            if (node.left != null) {
26                dfs(node.left, path, paths);
27            }
28            if (node.right != null) {
29                dfs(node.right, path, paths);
30            }
31        }
32
33        // Backtrack: restore the path length to what it was before this call
34        path.setLength(lengthBeforeAppend);
35    }
36}