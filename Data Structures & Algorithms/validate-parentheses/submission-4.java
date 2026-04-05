class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> bracketMap = new HashMap<>();
        bracketMap.put('}','{');
        bracketMap.put(')','(');
        bracketMap.put(']','[');


        Deque<Character> sDeque = new ArrayDeque<Character>();
        for(Character ch : s.toCharArray()){
            if(!bracketMap.containsKey(ch)){
                sDeque.addLast(ch);
            }else{
                if(sDeque.isEmpty()){
                    return false;
                }
                if(sDeque.removeLast()!=bracketMap.get(ch)){
                    return false;
                }
            }
        }

        if(sDeque.isEmpty()){
            return true;
        }

        return false;

    }
}
