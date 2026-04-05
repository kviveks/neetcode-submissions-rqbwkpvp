class Solution {
    Map<Character,String> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {

        if(digits==""){
            return new ArrayList<String>();
        }
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        dfs(digits,0,new StringBuilder());
        return res; 
    }

    public void dfs(String digits,int p,StringBuilder sb){
        if(p==digits.length()){
            res.add(sb.toString());
            return;
        }

        if(p>digits.length()){
            return;
        }

        for(int i=0;i<map.get(digits.charAt(p)).length();i++){
            sb.append(map.get(digits.charAt(p)).charAt(i));
            dfs(digits,p+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
