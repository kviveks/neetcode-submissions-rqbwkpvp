class Solution {
    Map<Integer,List<Integer>> adjMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> validCourse = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i=0;i<numCourses;i++){
            adjMap.put(i,new ArrayList<>());
        }
        
        for(int[] pre : prerequisites){
            adjMap.get(pre[0]).add(pre[1]);
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

        if(result==true){
            validCourse.add(course);
            return true;
        }

        return false;
    }
    }
