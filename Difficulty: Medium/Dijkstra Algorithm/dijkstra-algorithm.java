class Pair {
    int node, dist;
    Pair(int n, int d) {
        node = n;
        dist = d;
    }
}
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w)); // undirected
        }

        // Step 2: Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 3: TreeSet instead of PriorityQueue
        TreeSet<Pair> set = new TreeSet<>((a, b) -> {
            if (a.dist != b.dist) return a.dist - b.dist;
            return a.node - b.node; // tie-breaker
        });

        set.add(new Pair(src, 0));

        // Step 4: Process TreeSet
        while (!set.isEmpty()) {
            Pair cur = set.pollFirst(); // get and remove smallest
            int u = cur.node;

            for (Pair nei : adj.get(u)) {
                int v = nei.node, wt = nei.dist; // wt is edge weight

                if (dist[u] + wt < dist[v]) {
                    // Remove old entry if present
                    set.remove(new Pair(v, dist[v]));

                    dist[v] = dist[u] + wt;

                    set.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }
}