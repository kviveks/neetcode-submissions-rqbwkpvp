class Solution {
    Map<Character,String> phoneMap = new HashMap<>();
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {

        if(digits.length()==0){
            return new ArrayList<>();
        }
        phoneMap.put('2',"abc");
        phoneMap.put('3',"def");
        phoneMap.put('4',"ghi");
        phoneMap.put('5',"jkl");
        phoneMap.put('6',"mno");
        phoneMap.put('7',"pqrs");
        phoneMap.put('8',"tuv");
        phoneMap.put('9',"wxyz");

        dfs(digits,0,new StringBuilder());
        return res;
    }

    public void dfs(String digit,int p, StringBuilder sb){
        if(p==digit.length()){
            res.add(new String(sb));
            return;
        }

        for(char ch : phoneMap.get(digit.charAt(p)).toCharArray()){
            sb.append(ch);
            dfs(digit,p+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
