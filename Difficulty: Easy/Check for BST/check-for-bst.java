/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        // code here.
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);

        for (int i = 1; i < inorderList.size(); i++) {
            if (inorderList.get(i) <= inorderList.get(i - 1)) {
                return false; // not strictly increasing
            }
        }
        return true;
    }

    void inorder(Node node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.data);
        inorder(node.right, list);
    }
}