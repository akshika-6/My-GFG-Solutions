class Pair {
    int node, weight;
    Pair(int n, int w) {
        node = n;
        weight = w;
    }
}
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w)); // undirected graph
        }

        // Step 2: Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 3: Min-heap (distance, node)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Pair(src, 0));

        // Step 4: Process queue
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;
            int d = cur.weight;

            if (d > dist[u]) continue; // skip outdated entry

            for (Pair nei : adj.get(u)) {
                int v = nei.node, wt = nei.weight;
                if (dist[v] > dist[u] + wt) {
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }
}
