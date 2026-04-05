class Solution {

    Map<Character,String> digitMap;
    List<String> res;

    public List<String> letterCombinations(String digits) {

        if(digits == null || digits.length() == 0)
            return new ArrayList<>();

        digitMap = new HashMap<>();
        digitMap.put('2',"abc");
        digitMap.put('3',"def");
        digitMap.put('4',"ghi");
        digitMap.put('5',"jkl");
        digitMap.put('6',"mno");
        digitMap.put('7',"pqrs");
        digitMap.put('8',"tuv");
        digitMap.put('9',"wxyz");

        res = new ArrayList<>();
        dfs(digits,0,new StringBuilder());

        return res;
    }

    public void dfs(String digits,int p,StringBuilder sb){

        if(p==digits.length()){
            res.add(sb.toString());
            return;
        }

        String letters = digitMap.get(digits.charAt(p));

        for(char ch : letters.toCharArray()){
            sb.append(ch);
            dfs(digits,p+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
