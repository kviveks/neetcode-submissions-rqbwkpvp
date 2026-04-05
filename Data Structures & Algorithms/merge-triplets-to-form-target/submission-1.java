class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean top=false,mid=false,bottom=false;

        for(int i=0;i<triplets.length;i++){
            if(target[0]<=triplets[i][0]&&target[1]<=triplets[i][1]&&target[2]<=triplets[i][2]){
                if(target[0]==triplets[i][0]){
                    top=true;
                }
                if(target[1]==triplets[i][1]){
                    mid=true;
                }
                if(target[2]==triplets[i][2]){
                    bottom=true;
                }
            }
        } 

        return top && mid && bottom;   
    }
}
