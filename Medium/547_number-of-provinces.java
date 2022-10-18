// bfs
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                bfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private void bfs(int[][] isConnected, boolean[] visited, int cityNum) {
        // construct the queue
        Queue<Integer> queue = new LinkedList<>();
        
        // put the start node into queue and mark it
        visited[cityNum] = true;
        queue.offer(cityNum);
        
        // use while loop to check whether the queue is empty, then BSF
        // if it's empty, then it means the traversal ends
        while(!queue.isEmpty()) {
            Integer curCityNum = queue.poll();
            
            // use curCityNum as the circle centre, find the neightbor nodes by travering isConnected
            int size = isConnected[0].length;
            for (int adjCityNum = 0; adjCityNum < size; adjCityNum++) {
                if (isConnected[curCityNum][adjCityNum] == 1 && !visited[adjCityNum]) {
                    visited[adjCityNum] = true;
                    
                    queue.offer(adjCityNum);
                }
            }
        }
    }
}


// dfs
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int cityNum) {
        visited[cityNum] = true;
        int[] values = isConnected[cityNum];

        for (int i = 0; i < values.length; i++) {
            if (values[i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
    }
}