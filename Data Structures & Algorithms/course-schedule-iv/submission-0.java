class Solution {
    Map<Integer,List<Integer>> adjMap = new HashMap<>();
    Map<Integer,Set<Integer>> memo = new HashMap<>();
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        for(int i=0;i<numCourses;i++){
            adjMap.put(i,new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];
            adjMap.get(u).add(v);
        }

        for(int i=0;i<numCourses;i++){
            dfs(i);
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            int u = q[0], v = q[1];
            res.add(memo.get(u).contains(v));
        }

        return res;


    }

    public Set<Integer> dfs(int course){
        if(memo.containsKey(course)){
            return memo.get(course);
        }


        Set<Integer> reachable = new HashSet<>();

        for(int nei : adjMap.get(course)){
            reachable.add(nei);
            reachable.addAll(dfs(nei));
        }

        memo.put(course,reachable);
        return reachable;
    }
}