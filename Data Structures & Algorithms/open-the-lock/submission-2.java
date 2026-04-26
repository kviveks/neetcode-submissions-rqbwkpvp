class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        if(dead.contains("0000")){
            return -1;
        }

        Set<String> visited = new HashSet<>();
        visited.add("0000");
        Deque<String> queue = new ArrayDeque<>();
        queue.addLast("0000");

        int steps = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                String curr = queue.removeFirst();
                

                if(curr.equals(target)) return steps;
                //if(dead.contains(curr)) continue;

                

                for(int j=0;j<4;j++){
                    char[] arr = curr.toCharArray();

                    //move forward
                    char up = (char)((arr[j]-'0'+1)%10+'0');
                    arr[j] = up;
                    String next1 = new String(arr);

                    if (!visited.contains(next1) && !dead.contains(next1)) {
                        queue.addLast(next1);
                        visited.add(next1);
                    }

                    arr = curr.toCharArray();

                    //move backward
                    char down = (char)((arr[j]-'0'-1+10)%10+'0');
                    arr[j] = down;
                    String next2 = new String(arr);

                    if (!visited.contains(next2) && !dead.contains(next2)) {
                        queue.addLast(next2);
                        visited.add(next2);
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}