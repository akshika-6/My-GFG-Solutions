/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
//         TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
//         m_pre(root,0,map);
//         return new ArrayList<>(map.values());
//     }
//     public static void m_pre(Node root, int hd, TreeMap<Integer,ArrayList<Integer>> map){
//         if(root != null){
//             if(!map.containsKey(hd)){
//                 map.put(hd,new ArrayList<>());
//             }
//             map.get(hd).add(root.data);
//             m_pre(root.left,hd-1,map);
//             m_pre(root.right,hd+1,map);
//         }
//     }
// }




if (root == null) return new ArrayList<>();

        TreeMap<Integer, List<Integer>> colMap = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node node = p.node;
            int col = p.col;

            colMap.putIfAbsent(col, new ArrayList<>());
            colMap.get(col).add(node.data);

            if (node.left != null) q.offer(new Pair(node.left, col - 1));
            if (node.right != null) q.offer(new Pair(node.right, col + 1));
        }

        return new ArrayList<>(colMap.values()
                             .stream()
                             .map(list -> new ArrayList<>(list))
                             .toList());
    }

    static class Pair {
        Node node;
        int col;
        Pair(Node n, int c) {
            node = n;
            col = c;
        }
    }
}