class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        HashMap<String,List<String>> hash = new HashMap<>();
        for(int i = 0; i< strs.length;i++){
            String ana = produceSorted(strs[i]);
            if(hash.containsKey(ana)){
                hash.get(ana).add(strs[i]);
            }else{
                List<String> sList = new ArrayList<>();
                sList.add(strs[i]);
                hash.put(ana,sList);
            }
        }

        for( List<String> ls : hash.values()){
            result.add(ls);
        }

        return result;
        
    }

    public String produceSorted(String s){
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
