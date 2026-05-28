class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = s1.length();

        if(s2.length()<l){
            return false;
        }

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];


        for(int i=0;i<l;i++){
            s1Freq[s1.charAt(i)-'a']++;
            s2Freq[s2.charAt(i)-'a']++;
        }

        if(isMatch(s1Freq,s2Freq)){
            return true;
        }


        for(int i=l;i<s2.length();i++){
            s2Freq[s2.charAt(i)-'a']++;
            s2Freq[s2.charAt(i-l)-'a']--;

            if(isMatch(s1Freq,s2Freq)){
            return true;
            }

        }

        return false;


    }

    public boolean isMatch(int[] s1,int[] s2){
        for(int i=0;i<26;i++){
            if(s1[i]!=s2[i]){
                return false;
            }
        }
        return true;
    }
}
