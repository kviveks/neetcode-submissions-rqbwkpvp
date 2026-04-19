class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks==null || matchsticks.length<4){
            return false;
        }

        int sum = 0;
        for(int x : matchsticks){
            sum+=x;
        }

        if(sum%4!=0) return false;

        int target = sum/4;

        Arrays.sort(matchsticks);
        reverse(matchsticks);

        int[] sides = new int[4];
        return dfs(matchsticks,0,sides,target);
    }

    public boolean dfs(int[] matchsticks,int p,int[] sides,int target){
        if(p==matchsticks.length){
            return sides[0]==target && sides[1]==target && sides[2]==target && sides[3]==target;
        }


        int stick = matchsticks[p];

        for(int i=0;i<4;i++){
            if(sides[i]+stick>target){
                continue;
            }

            sides[i]+=stick;
            if(dfs(matchsticks,p+1,sides,target)){
                return true;
            }
            sides[i]-=stick;
        }

        return false;
    }

    private void reverse(int[] arr) {
    int l = 0, r = arr.length - 1;
    while (l < r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        l++;
        r--;
    }
}
}