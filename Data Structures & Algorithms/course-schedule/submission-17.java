class Solution {
    Map<Integer,List<Integer>> adjMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> validCourse = new HashSet<>();
    boolean res = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++){
            adjMap.put(i,new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];
            adjMap.get(u).add(v);
        }

        for(int i=0;i<numCourses;i++){
            visited = new HashSet<>();
            dfs(i,visited);
            if(res==false)
                break;
        }

        return res;

    }

    public void dfs(int course,Set<Integer> visited){
        if(res==false){
            return;
        }

        if(visited.contains(course)){
            res=false;
            return;
        }

        visited.add(course);
        for(int i=0;i<adjMap.get(course).size();i++){
            dfs(adjMap.get(course).get(i),visited);
        }

        visited.remove(course);

        if(res!=false){
            validCourse.add(course);
        }
    }
}
