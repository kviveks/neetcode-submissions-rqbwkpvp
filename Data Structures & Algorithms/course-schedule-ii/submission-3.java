class Solution {
    Map<Integer,List<Integer>> adjMap = new HashMap<>();
    Set<Integer> validCourse = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    List<Integer> res = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++){
            adjMap.put(i,new ArrayList<>());
        }

        for(int[] course : prerequisites){
            int u = course[0];
            int v = course[1];
            adjMap.get(u).add(v);
        }

        for(int i=0;i<numCourses;i++){
            if(!dfs(i)){
                return new int[]{};
            }
        }

        int[] ans = new int[numCourses];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }

        return ans;
    }

    public boolean dfs(int course){
        if(visited.contains(course)){
            return false;
        }

        if(validCourse.contains(course)){
            return true;
        }

        visited.add(course);
        boolean r = true;
        for(int i=0;i<adjMap.get(course).size();i++){
            r = r & dfs(adjMap.get(course).get(i));
        }

        visited.remove(course);
        res.add(course);
        validCourse.add(course);

        return r;
    }
}
