// class Solution {
//     public boolean canJump(int[] nums) {
//         int[] jumpAllowed = new int[nums.length];
//         jumpAllowed[0]=1;

//         for(int i = 0;i<nums.length;i++){
//             if(jumpAllowed[i]==1){
//                 for(int j=1;j<=nums[i]&&j+i<nums.length;j++){
//                     jumpAllowed[i+j]=1;
//                 }
//             }
//         }

//         return jumpAllowed[nums.length-1]==1?true:false;
//     }
// }

class Solution {
    public boolean canJump(int[] nums) {

        int maxReach = 0;

        for(int i =0;i<nums.length;i++){
            if(maxReach < i){
                return false;
            }

            maxReach = Math.max(maxReach,i+nums[i]);
            if(maxReach>= nums.length-1){
                return true;
            }
        }

        return false;
    }
}
