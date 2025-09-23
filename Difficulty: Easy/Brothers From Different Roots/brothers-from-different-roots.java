/*Structure of the Node of the BST is as
class Node
{
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public static int countPairs(Node root1, Node root2, int x) {
        // Code here
        if (root1 == null || root2 == null) return 0;

        Stack<Node> s1 = new Stack<>(); // inorder stack for BST1 (ascending)
        Stack<Node> s2 = new Stack<>(); // reverse inorder stack for BST2 (descending)

        Node curr1 = root1, curr2 = root2;
        int count = 0;

        while (true) {
            // push left nodes of BST1
            while (curr1 != null) {
                s1.push(curr1);
                curr1 = curr1.left;
            }

            // push right nodes of BST2
            while (curr2 != null) {
                s2.push(curr2);
                curr2 = curr2.right;
            }

            if (s1.isEmpty() || s2.isEmpty()) break;

            Node top1 = s1.peek();
            Node top2 = s2.peek();

            int sum = top1.data + top2.data;

            if (sum == x) {
                count++;
                // move to next bigger in BST1 and next smaller in BST2
                s1.pop();
                s2.pop();
                curr1 = top1.right;
                curr2 = top2.left;
            } else if (sum < x) {
                // need bigger from BST1
                s1.pop();
                curr1 = top1.right;
            } else {
                // need smaller from BST2
                s2.pop();
                curr2 = top2.left;
            }
        }
        return count;
    }
}