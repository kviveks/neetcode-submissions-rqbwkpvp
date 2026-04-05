class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int l = numbers.length;

        int left=0,right=l-1;

        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(target == sum){
                return new int[]{numbers[left],numbers[right]};
            }

            if(target>sum){
                left++;
            }

            if(target<sum){
                right--;
            }
        }

        return null;
        
    }
}
