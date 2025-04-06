class Solution {
    // Using DFS
    public int countComponents(int n, int[][] edges) {
        // the times of DFS that we need in order to traverse all vertices
        int count = 0;

        // Step 0: adjancency list
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 1: DFS
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(adj, isVisited, i);
                count++;
            }
        }

        return count;
    }

    private void dfs(Map<Integer, List<Integer>> adj, boolean[] isVisited, int nodeNum) {
        isVisited[nodeNum] = true;
        for (int adjNode: adj.get(nodeNum)) {
            if (!isVisited[adjNode]) {
                dfs(adj, isVisited, adjNode);
            }
        }
    }
    
}