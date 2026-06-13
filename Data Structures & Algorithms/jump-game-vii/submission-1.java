class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        Deque<Integer> q = new ArrayDeque<>();

        q.add(0);
        int farthest = 0;
        int n = s.length();

        while(!q.isEmpty()){
            int i = q.poll();
            int start = Math.max(i+minJump,farthest);
            int end = Math.min(i+maxJump,n-1);

            for(int j=start;j<=end;j++){
                if(s.charAt(j)=='0'){
                    if(j==n-1){
                        return true;
                    }
                    q.addLast(j);
                }
            }

            farthest = Math.max(farthest,end+1);
        }

        return false;
    }
}