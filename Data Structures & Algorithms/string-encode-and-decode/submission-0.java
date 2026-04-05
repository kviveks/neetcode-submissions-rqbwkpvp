class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        int l;
        for(int i = 0; i<strs.size(); i++){
            sb.append(strs.get(i));
            sb.append("vivek");
        }

        return sb.toString();

    }

    public List<String> decode(String str) {
        String[] s = str.split("vivek");
        List<String> result = new ArrayList<>(Arrays.asList(s));
        //result.remove(result.size() - 1); 
        return result;
    }
}
