class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        for(int i=0;i<V;i++){
            ls.add(new ArrayList<>());
        }
        for(int[]d :edges){
            ls.get(d[0]).add(d[1]);
            
        }
        ArrayList<Integer> l = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, ls, visited, l)) {
                    return true;
                }
            }
        }
        return false;
        
    }
     public static boolean dfs(int node,ArrayList<ArrayList<Integer>> ls,boolean[] visited,ArrayList<Integer> path){
        visited[node] = true;
        path.add(node);
        for(int d:ls.get(node)){
            if(visited[d]==false){
                if(dfs(d,ls,visited,path)){
                    return true;
                }
            }
            else if(path.contains(d)){
                return true;
            }
        }
        path.remove(path.size()-1);
        return false;
        
    }
}

    