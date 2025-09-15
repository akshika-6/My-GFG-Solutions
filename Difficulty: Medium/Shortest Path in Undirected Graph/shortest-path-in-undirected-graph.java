class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int n=adj.size();
        int dist[]=new int[n];
        Arrays.fill(dist,-1);
        Queue<Integer> q=new LinkedList<>();
        dist[src]=0;
        q.offer(src);
        while(!q.isEmpty()){
            int node=q.poll();
            for(int i:adj.get(node)){
                if(dist[i] == -1){
                    dist[i]=dist[node]+1;
                    q.offer(i);
                }
            }
        }
        return dist;
    }
}
