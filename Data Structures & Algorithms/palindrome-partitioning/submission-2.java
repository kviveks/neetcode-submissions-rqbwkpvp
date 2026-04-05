class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(new ArrayList<String>(),0,s);
        return res;  
    }

    public void dfs(List<String> curr,int p,String s){

        if(p>s.length()){
            return;
        }

        if(p==s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = p;i<s.length();i++){
            String newS = s.substring(p,i+1);
            if(isPal(newS)){
                curr.add(newS);
                dfs(curr,i+1,s);
                curr.remove(curr.size()-1);
            }
        }
    }

    public boolean isPal(String s){
        int l=0;
        int r=s.length()-1;
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    }

