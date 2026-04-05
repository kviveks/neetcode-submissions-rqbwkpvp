class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()){
            return false;
        }

        int[] s1char = new int[26];
        int[] s2char = new int[26];

        for(int i=0;i<s1.length();i++){
            s1char[s1.charAt(i)-'a']++;
            s2char[s2.charAt(i)-'a']++;
        }

        if(match(s1char,s2char)){
            return true;
        }

        for(int i=s1.length();i<s2.length();i++){
            s2char[s2.charAt(i-s1.length())-'a']--;
            s2char[s2.charAt(i)-'a']++;

            if(match(s1char,s2char)){
                return true;
        }

        }

        return false;
    }

    public boolean match(int[] s1,int[] s2){
        for(int i=0;i<26;i++){
            if(s1[i]!=s2[i]){
                return false;
            }
        }
        return true;
    }
}
