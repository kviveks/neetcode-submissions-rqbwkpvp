class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n =matrix[0].length;

        int l = 0;
        int r = m-1;

        int requiredRow = 0;

        while(l<=r){
            int mid = (l+r)/2;
            if(target>=matrix[mid][0] && target<=matrix[mid][n-1]){
                requiredRow = mid;
                break;
            }else if(target<matrix[mid][0]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }

        l=0;
        r=n-1;

        while(l<=r){
            int mid=(l+r)/2;
            if(matrix[requiredRow][mid]==target){
                return true;
            }else if(matrix[requiredRow][mid]>target){
                r=mid-1;
            }else if(matrix[requiredRow][mid]<target){
                l=mid+1;
            }
        }

        return false;

        
        
    }
}
