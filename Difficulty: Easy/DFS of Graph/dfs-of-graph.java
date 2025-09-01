class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int V = adj.size(); // number of vertices
        boolean[] visited = new boolean[V]; // visited array
        ArrayList<Integer> result = new ArrayList<>(); // store traversal
        
        // start DFS from node 0
        dfsUtil(0, adj, visited, result);
        
        return result;
    }
    
    // Helper recursive function
    private void dfsUtil(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true; // mark as visited
        result.add(node);     // add to traversal
        
        // explore all unvisited neighbors
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, adj, visited, result);
            }
        }
    }
}