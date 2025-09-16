class UnionFind{
    int parent[];
    int rank[];
    UnionFind(int V){
        parent = new int[V+1];
        rank = new int[V+1];
        for(int i=0;i<V;i++){
            parent[i]=i;
        }
    }
    int find(int node){
        if(parent[node] == node) return node;
        return find(parent[node]);
    }
    boolean union(int u,int v){
        int pu=find(u);
        int pv=find(v);
        if(pu == pv){
            return false;
        }
        if(rank[pu] > rank[pv]){
            parent[pv]=pu;
        } else if(rank[pv] > rank[pu]){
            parent[pu]=pv;
        } else{
            parent[pv]=pu;
            pu++;
        }
        return true;
    }
}
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        UnionFind uf=new UnionFind(V);
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            if(uf.union(u,v) == false){
                return true;
            }
        }
        return false;
    }
}