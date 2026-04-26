class Solution {
    Map<Integer,List<Integer>> adjMap = new HashMap<>();
    Set<Integer> validCourse = new HashSet<>();
    List<Integer> res = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++){
            adjMap.put(i,new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];
            adjMap.get(u).add(v);
        }

        for(int i=0;i<numCourses;i++){
            if(!dfs(i,new HashSet<>())){
                return new int[]{};
            }
        }
        int[] ans = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }

        return ans;
    }


    public boolean dfs(int course,Set<Integer> visited){
        if(visited.contains(course)){
            return false;
        }

        if(validCourse.contains(course)){
            return true;
        }


        visited.add(course);

        boolean flag =true;
        for(int i=0;i<adjMap.get(course).size();i++){
            flag = flag && dfs(adjMap.get(course).get(i),visited);
        }

        visited.remove(course);
        if(flag==true){
            res.add(course);
            validCourse.add(course);
        }
        return flag;
    }
}
