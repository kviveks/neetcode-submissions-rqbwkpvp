class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int[] result = new int[k];

        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }


        TreeMap<Integer,Integer> treeMap = new TreeMap<>();

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            treeMap.put(entry.getValue(),entry.getKey());
        }

        int[] tempResult = new int[treeMap.size()];

        int count=0;
        for(Map.Entry<Integer,Integer> entry : treeMap.entrySet()){
            tempResult[count] = entry.getValue();
            count++;
        }

        for(int i = 1;i<=k;i++){
            result[i-1]=tempResult[tempResult.length-i];
        }

        return result;


    }
}
