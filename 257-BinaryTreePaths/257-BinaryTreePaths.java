// Last updated: 28/07/2026, 15:43:27
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            dfs(root, new StringBuilder(), paths);
        }
        return paths;
    }

    private void dfs(TreeNode node, StringBuilder path, List<String> paths) {
        int lengthBeforeAppend = path.length();
        
        // Append the current node's value
        path.append(node.val);

        // Check if it's a leaf node
        if (node.left == null && node.right == null) {
            paths.add(path.toString());
        } else {
            // If not a leaf, add the delimiter and continue exploring children
            path.append("->");
            if (node.left != null) {
                dfs(node.left, path, paths);
            }
            if (node.right != null) {
                dfs(node.right, path, paths);
            }
        }

        // Backtrack: restore the path length to what it was before this call
        path.setLength(lengthBeforeAppend);
    }
}