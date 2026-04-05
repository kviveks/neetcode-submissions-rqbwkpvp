class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> availableList = new ArrayList<>();
        for (int num : nums) {
            availableList.add(num);
        }
        backTrack(new ArrayList<Integer>(), availableList);
        return res;    
    }


    public void backTrack(List<Integer> currentList,List<Integer> avaiableList){
        if(avaiableList.size()==0){
            res.add(new ArrayList<>(currentList));
            return;
        }

        for(int i = 0; i < avaiableList.size();i++){
            currentList.add(avaiableList.get(i));
            List<Integer> newAvailableList = new ArrayList<>(avaiableList);
            newAvailableList.remove(i);
            backTrack(currentList,newAvailableList);
            currentList.remove(currentList.size()-1); 
        }
    }



}
