class Solution {
    Set<Integer> validCourse = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    List<Integer> res = new ArrayList<>();
    Map<Integer,List<Integer>> adjMap = new HashMap<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++){
            adjMap.put(i,new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            adjMap.get(pre[0]).add(pre[1]);
        }


        for(int i =0;i<numCourses;i++){
            visited = new HashSet<>();
            if(!validCourse.contains(i)){
                if(!dfs(i)){
                    return new int[]{};
                }
            }
        }

        int[] ar = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ar[i]=res.get(i);
        }

        return ar;
    }

    public boolean dfs(int course){
        if(validCourse.contains(course)){
            return true;
        }

        if(visited.contains(course)){
            return false;
        }

        visited.add(course);

        boolean result = true;
        for(int i=0;i<adjMap.get(course).size();i++){
            result = result && dfs(adjMap.get(course).get(i));
        }

        visited.remove(course);

        if(result){
            res.add(course);
            validCourse.add(course);
            return true;
        }

        return false;
    }
}
