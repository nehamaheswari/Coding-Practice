//Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution {
    public List<Integer> postorder(Node root) {
     List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traverse(root, result);
        return result;
    }

    private void traverse(Node node, List<Integer> result) {
        for (Node child : node.children) {
            traverse(child, result);
        }
        result.add(node.val);
    }
}
