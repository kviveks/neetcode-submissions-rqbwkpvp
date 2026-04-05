class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> hashmap = new HashMap<>();


        for(Character c : s.toCharArray()){
            if(hashmap.containsKey(c)){
                hashmap.put(c,hashmap.get(c)+1);
            }else{
                hashmap.put(c,1);
            }
        }

        for(Character c : t.toCharArray()){
            if(hashmap.containsKey(c)){
                hashmap.put(c,hashmap.get(c)-1);
            }else{
                return false;
            }
        }

        for(Character c : hashmap.keySet()){
            if(hashmap.get(c)!=0){
                return false;
            }
        }

        return true;   
    }
}
