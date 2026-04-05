class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }

        char[] sch = new char[s.length()];
        char[] tch = new char[t.length()];

        for(int i = 0;i<s.length();i++){
            sch[i] = s.charAt(i);
        }

        for(int j=0;j<t.length();j++){
            tch[j]=t.charAt(j);
        }

        Arrays.sort(sch);
        Arrays.sort(tch);


        for (int i=0;i<s.length();i++){
            if(sch[i]!=tch[i]){
                return false;
            }
        }

        return true;
    }
}
