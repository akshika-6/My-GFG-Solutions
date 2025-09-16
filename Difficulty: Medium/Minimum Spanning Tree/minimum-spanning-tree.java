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
    public int spanningTree(int V, int[][] edges) {
        // code here
        UnionFind uf = new UnionFind(V);
        int count=0;
        int res =0;
        Arrays.sort(edges,(a,b) -> a[2]-b[2]);
        for(int[] arr:edges){
            if(uf.union(arr[0],arr[1])==true){
                count++;
                res += arr[2];
                if(count == V-1) break;
        }
        }
        return res;
    }
}
