/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)
   {
        data = item;
        left = right = null;
    }
} */

class Solution {
    void mirror(Node node) {
        // code here
        if (node == null) return;

        // swap children
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        // invert subtrees
        mirror(node.left);
        mirror(node.right);

        return;
    }
}