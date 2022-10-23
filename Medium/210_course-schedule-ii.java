class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int index = 0;
        // [0, 1] => 1 -> 0
        // construct a adjancency list
        // key: course number - graphNodes list's index, value: neighbor nodes
        List<List<Integer>> graphNodes = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            graphNodes.add(new ArrayList<>());
        } 
        
        for (int[] edge: prerequisites) {
            int start = edge[1];
            int end = edge[0];
            graphNodes.get(start).add(end);
        }
        
        // calculate the in-degree for all nodes
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        for (List<Integer> adjNodes: graphNodes) {
            for (Integer adjNode: adjNodes) {
                if (indegreeMap.containsKey(adjNode)) {
                    indegreeMap.put(adjNode, indegreeMap.get(adjNode) + 1);
                } else {
                    indegreeMap.put(adjNode, 1);
                }
            }
        }
        
        // put all nodes with 0 in-degree into a queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!indegreeMap.containsKey(i)) {
                queue.offer(i);
                result[index++] = i;
            }
        }
        
        // BFS
        while (!queue.isEmpty()) {
            Integer curNode = queue.poll();
            List<Integer> adjNodes = graphNodes.get(curNode);
            for (Integer adjNode: adjNodes) {
                // its neightbor indegree decrease by 1
                int updatedIndegree = indegreeMap.get(adjNode) - 1;
                indegreeMap.put(adjNode, updatedIndegree);
                
                // after update, if its indegree is 0, then put it into queue
                if (updatedIndegree == 0) {
                    queue.offer(adjNode);
                    result[index++] = adjNode;
                }
            }
        }
        
        if (index == numCourses) {
            return result;
        }
        
        return new int[0];
    }
}