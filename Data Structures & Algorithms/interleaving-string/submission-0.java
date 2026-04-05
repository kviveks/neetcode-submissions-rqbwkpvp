class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        int l1=0,l2=0;
        boolean first = true;

        for(int i = 0;i<len3;i++){
            if(first){
            if(l1<len1 && s3.charAt(i)==s1.charAt(l1)){
                first=true;
                l1++;
            }else if(l2 < len2 && s3.charAt(i)==s2.charAt(l2)){
                first=false;
                l2++;
            }else{
                return false;
            }
            }else{
            if(l2<len2 && s3.charAt(i)==s2.charAt(l2)){
                first=false;;
                l2++;
            }else if(l1<len1 && s3.charAt(i)==s1.charAt(l1)){
                first=true;
                l1++;
            }else{
                return false;
            }
            }
        }

        return true;
    }
}
