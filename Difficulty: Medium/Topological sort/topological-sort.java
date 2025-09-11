class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e:edges){
            graph.get(e[0]).add(e[1]);
        }
        boolean[] visited = new boolean[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,visited,graph,st);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
    public static void dfs(int node,boolean[] visited,List<List<Integer>> graph,Stack<Integer> st){
        visited[node]=true;
        for(int nei:graph.get(node)){
            if(!visited[nei]){
                dfs(nei,visited,graph,st);
            }
        }
        st.push(node);
    }
}