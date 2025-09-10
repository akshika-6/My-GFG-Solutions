class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n=adj.size();
        boolean[] visited=new boolean[n];
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs1(i,visited,ans,adj);
            }
        }
        return ans;
    }
    public static void dfs1(int node,boolean[] visited,ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> adj){
        visited[node]=true;
        ans.add(node);
        for(int a:adj.get(node)){
            if(!visited[a]){
                dfs1(a,visited,ans,adj);
            }
        }
    }
}