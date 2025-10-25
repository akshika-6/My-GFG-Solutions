/*
class Node {
    int data;
    Node left, right;

    public Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    
    public ArrayList<Integer> merge(Node root1, Node root2) {
        // code here
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        while (root1 != null || root2 != null || !s1.isEmpty() || !s2.isEmpty()) {
            // Push left children to stack 1
            while (root1 != null) {
                s1.push(root1);
                root1 = root1.left;
            }
            // Push left children to stack 2
            while (root2 != null) {
                s2.push(root2);
                root2 = root2.left;
            }
            
            if (s2.isEmpty() || (!s1.isEmpty() && s1.peek().data <= s2.peek().data)) {
                root1 = s1.pop();
                result.add(root1.data);
                root1 = root1.right;
            } else {
                root2 = s2.pop();
                result.add(root2.data);
                root2 = root2.right;
            }
        }
        
        return result;
    }
}