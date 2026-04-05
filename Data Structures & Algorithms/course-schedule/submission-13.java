class Solution {
    Map<Integer,List<Integer>> adjMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> validCourse = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        for(int i=0;i<numCourses;i++){
            adjMap.put(i, new ArrayList<Integer>());
        }

        for(int[] course : prerequisites){
            int u = course[0];
            int v = course[1];
            adjMap.get(u).add(v);
        }

        for(int i=0;i<numCourses;i++){
            visited = new HashSet<>();
            if(!dfs(i)){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int course){
        if(visited.contains(course)){
            return false;
        }

        if(validCourse.contains(course)){
            return true;
        }

        visited.add(course);

        boolean res = true;
        for(int i=0;i<adjMap.get(course).size();i++){
            res = res && dfs(adjMap.get(course).get(i));    
        }

        visited.remove(course);

        return res;
    }
}
