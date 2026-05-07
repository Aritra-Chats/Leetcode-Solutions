class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adjList.add(new ArrayList<>());
        for(int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
            indegrees[prerequisite[0]]++;
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegrees.length; i++)
            if(indegrees[i] == 0) q.offer(i);
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int i : adjList.get(node)) {
                indegrees[i]--;
                if(indegrees[i] == 0) q.offer(i);
            }
            count++;
        }
        return count == numCourses;
    }
}
