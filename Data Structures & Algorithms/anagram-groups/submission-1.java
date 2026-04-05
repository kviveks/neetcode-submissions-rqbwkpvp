class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(int i = 0;i<strs.length;i++){
            String tmp = sortIt(strs[i]);
            map.putIfAbsent(tmp,new ArrayList<String>());
            map.get(tmp).add(strs[i]);
        }

        for(List<String> ls : map.values()){
            result.add(ls);
        }

        return result;
        
    }

    public String sortIt(String s){
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
