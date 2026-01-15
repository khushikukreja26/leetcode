class Solution {

    static class DSU {
        int[] parent;
        int[] size;

        // Initialize DSU with each node as its own parent
        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // Find the root of a node with path compression
        private int find(int node) {
            if (node == parent[node])
                return node;

            return parent[node] = find(parent[node]);
        }

        // Union two sets by size
        private void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            // Already in the same set
            if (rootA == rootB)
                return;

            // Attach smaller tree under larger tree
            if (size[rootA] > size[rootB]) {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            } else {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            }
        }
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        DSU dsu = new DSU(n);

        // Iterate through all nodes
        for (int u = 0; u < n; u++) {

            int k = graph[u].length;

            // If the node has neighbors
            if (k > 0) {

                // Take the first neighbor as reference
                int first = graph[u][0];

                // Process all neighbors of u
                for (int v = 0; v < k; v++) {

                    int neighbor = graph[u][v];

                    // If u and its neighbor are in the same set → conflict
                    if (dsu.find(u) == dsu.find(neighbor))
                        return false;

                    // Union all neighbors together
                    dsu.union(first, neighbor);
                }
            }
        }

        return true;
    }
}