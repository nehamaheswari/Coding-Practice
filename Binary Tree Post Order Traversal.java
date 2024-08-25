import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        // Traverse left subtree
        postorderHelper(node.left, result);

        // Traverse right subtree
        postorderHelper(node.right, result);

        // Visit root node
        result.add(node.val);
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        BinaryTreePostorderTraversal traversal = new BinaryTreePostorderTraversal();
        List<Integer> result = traversal.postorderTraversal(root);

        System.out.println(result);  // Output: [3, 2, 1]
    }
}
