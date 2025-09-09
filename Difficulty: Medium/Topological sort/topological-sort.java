class Solution {
    public static void dfs(int node,ArrayList<ArrayList<Integer>> ls,boolean[] visited,Stack<Integer> st){
        visited[node] = true;
        for(int d:ls.get(node)){
            if(!visited[d]){
                dfs(d,ls,visited,st);
            }
        }
        st.push(node);
    }
    
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        for(int i=0;i<V;i++){
            ls.add(new ArrayList<>());
        }
        for(int[] d:edges){
            ls.get(d[0]).add(d[1]);
        }
        Stack<Integer> st=new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,ls,visited,st);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
}