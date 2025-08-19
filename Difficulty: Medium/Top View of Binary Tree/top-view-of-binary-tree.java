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
    
     static class Pair {
    Node node;
    int hd;
    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}
 static void helper(Node root, int hd, TreeMap<Integer,ArrayList<Integer>> map) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, hd));
        while(!q.isEmpty()) {
            Pair n = q.poll();
            Node curr = n.node;
            int val = n.hd;
            if(!map.containsKey(val)) {
                map.put(val, new ArrayList<>());
                map.get(val).add(curr.data);
            }
            
            if(curr.left!=null) {
                q.add(new Pair(curr.left, val-1));
            }
            if(n.node.right!=null) {
                q.add(new Pair(curr.right, val+1));
            }
        }
    }

    static ArrayList<Integer> topView(Node root) {
        // code here
        TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<>();
        /*modifiedPreorder(root, 0, map);
        return new ArrayList<>(map.values());*/
        helper(root, 0, map);
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer>>  e: map.entrySet()) {
            ArrayList<Integer> l = e.getValue();
            list.add(l.get(0));
        }
        return list;
    }
}