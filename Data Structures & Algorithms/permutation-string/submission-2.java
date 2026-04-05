class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if(l1>l2){
            return false;
        }
        char[] s1Char = new char[26];
        char[] s2Char = new char[26];

        for(int i =0;i<l1;i++){
            s1Char[s1.charAt(i)-'a']++;
            s2Char[s2.charAt(i)-'a']++;
        }

        for(int i = s1.length();i<=s2.length()-s1.length();i++){
            if(isMatch(s1Char,s2Char)){
                return true;
            }

            s2Char[s2.charAt(i-s1.length())-'a']--;
            s2Char[s2.charAt(i)-'a']++;
        }

        return false;


    }

    public boolean isMatch(char[] s1Char,char[] s2Char){
        for(int i=0;i<26;i++){
            if(s1Char[i]!=s2Char[i]){
                return false;
            }
        }
        return true;
    }


}
