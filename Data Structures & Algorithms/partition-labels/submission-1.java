class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            last[ch-'a']=i;
        }


        int end = 0;
        int start = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            end = Math.max(end,last[ch-'a']);

            if(i==end){
                res.add(end-start+1);
                start=i+1;
            }
        }

        return res;
    }
}
