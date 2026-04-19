class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums==null || nums.length<k){
            return false;
        }

        int sum = 0;
        for(int x : nums){
            sum+=x;
        }

        if(sum%k!=0){
            return false;
        }

        int target = sum/k;
        Arrays.sort(nums);
        reverse(nums);

        int[] buckets = new int[k];
        return dfs(nums,k,0,buckets,target);
    }

    public boolean dfs(int[] nums,int k,int p,int[] buckets,int target){
        if(p==nums.length){
            for(int bucket : buckets){
                if(bucket!=target){
                    return false;
                }
            }
            return true;
        }

        int num = nums[p];

        for(int i=0;i<k;i++){
            if(buckets[i]+num>target){
                continue;
            }

            buckets[i]+=num;
            if(dfs(nums,k,p+1,buckets,target)){
                return true;
            }
            buckets[i]-=num;
        }

        return false;
    }

    public void reverse(int[] ar){
        int l=0,r=ar.length-1;
        while(l<r){
            int temp = ar[l];
            ar[l]=ar[r];
            ar[r]=temp;
            l++;
            r--;
        }
    }
}