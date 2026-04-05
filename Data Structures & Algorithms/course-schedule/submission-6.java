class Solution {
    public List<List<Integer>> adj;
    public Set<Integer> validCourse;
    public Set<Integer> visited;
    public boolean canFinish(int numCourses, int[][] prereq) {
        adj = new ArrayList<>();
        validCourse = new HashSet<>();
        

        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<prereq.length;i++){
            adj.get(prereq[i][0]).add(prereq[i][1]);
        }

        for(int i = 0;i<numCourses;i++){
            visited = new HashSet<>();
            if(!dfs(i,visited)){
                return false;
            }
        }

        return true;

    }

    public boolean dfs(int course, Set<Integer> visited){

        if (validCourse.contains(course)) return true;

        if(visited.contains(course)){
            return false;
        }
        visited.add(course);

        if(adj.get(course).size()==0){
            validCourse.add(course);
            return true;
        }

        boolean result = true;

        for(int i = 0;i<adj.get(course).size();i++){
            result = result && dfs(adj.get(course).get(i),visited);
        }

        visited.remove(course);

        if(result==true){
            validCourse.add(course);
            return true;
        }

        return false;
    }
}
