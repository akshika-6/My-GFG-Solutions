// User function Template for Java
class Pair{
    int nbr;
    int weight;
    Pair(int n,int w){
        nbr = n;
        weight = w;
    }
}
class Solution {
    private void topoSort(int node, boolean[] visited, Stack<Integer> st, ArrayList<ArrayList<Pair>> adj) {
        visited[node] = true;
        for (Pair p: adj.get(node)) {
            if (!visited[p.nbr]) {
                topoSort(p.nbr, visited, st, adj);
            }
        }
        st.push(node);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v,w));
        }
        
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSort(i, visited, st, adj);
            }
        }
        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        while(!st.isEmpty()){
            int node = st.pop();
            if(dist[node] != Integer.MAX_VALUE){
                for(Pair p:adj.get(node)){
                    if(dist[node] + p.weight < dist[p.nbr]){
                        dist[p.nbr]=dist[node]+p.weight;
                    }
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }
}