class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        for(Character ch : s.toCharArray()){
            if(map.containsKey(ch)){
                if(stack.isEmpty()){
                    return false;
                }
                Character p = stack.pop();
                if(p!=map.get(ch)){
                    return false;
                }
            }else{
                stack.push(ch);
            }
            //System.out.println(stack.peek());
        }

        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
