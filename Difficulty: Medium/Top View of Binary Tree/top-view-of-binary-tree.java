/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    
    static class Pair {
        Node node;
        int hd; // horizontal distance
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    static ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        
        Map<Integer, Integer> map = new HashMap<>(); // hd -> node value
        Queue<Pair> q = new LinkedList<>();
        
        int minHD = 0, maxHD = 0;
        
        q.offer(new Pair(root, 0));
        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node node = p.node;
            int hd = p.hd;
            
            // Only take the first node for this hd
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }
            
            minHD = Math.min(minHD, hd);
            maxHD = Math.max(maxHD, hd);
            
            if (node.left != null) {
                q.offer(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                q.offer(new Pair(node.right, hd + 1));
            }
        }
        
        // Collect results from leftmost hd to rightmost hd
        for (int i = minHD; i <= maxHD; i++) {
            ans.add(map.get(i));
        }
        
        return ans;
    }
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//         TreeMap<Integer, Integer> map = new TreeMap<>();
//         m_pre(root, 0, map);
//         return new ArrayList<>(map.values());
//     }
    
//     public static void m_pre(Node root, int hd, TreeMap<Integer, Integer> map) {
//         if (root != null) {
//             // Only add the first node we encounter at this horizontal distance
//             if (!map.containsKey(hd)) {
//                 map.put(hd, root.data);
//             }
//             m_pre(root.left, hd - 1, map);
//             m_pre(root.right, hd + 1, map);
//         }
//     }
// }