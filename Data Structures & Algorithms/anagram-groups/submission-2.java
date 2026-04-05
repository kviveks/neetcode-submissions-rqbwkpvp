class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> hash = new HashMap<>();
        for(String s : strs){
            String ana = produceSorted(s);
            if(hash.containsKey(ana)){
                hash.get(ana).add(s);
            }else{
                hash.put(ana,new ArrayList<String>());
                hash.get(ana).add(s);
            }
        }

        for(List<String> ls : hash.values()){
            res.add(ls);
        }
        return res;
    }


    public String produceSorted(String s){
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
