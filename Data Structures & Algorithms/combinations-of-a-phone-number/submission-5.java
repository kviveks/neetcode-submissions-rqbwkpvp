class Solution {
    List<String> res = new ArrayList<String>();
    Map<Character,String> phoneMap = new HashMap<>();
    public List<String> letterCombinations(String digits) {

        if(digits.isEmpty()){
            return new ArrayList<String>();
        }
        phoneMap.put('2',"abc");
        phoneMap.put('3',"def");
        phoneMap.put('4',"ghi");
        phoneMap.put('5',"jkl");
        phoneMap.put('6',"mno");
        phoneMap.put('7',"pqrs");
        phoneMap.put('8',"tuv");
        phoneMap.put('9',"wxyz");
        dfs(0,digits,new StringBuilder());

        return res;
    }

    public void dfs(int p,String digits,StringBuilder sb){
        if(p==digits.length()){
            res.add(new String(sb.toString()));
            return;
        }


        for(char ch : phoneMap.get(digits.charAt(p)).toCharArray()){
            sb.append(ch);
            dfs(p+1,digits,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
