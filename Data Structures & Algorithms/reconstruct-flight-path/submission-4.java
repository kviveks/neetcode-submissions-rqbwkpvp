class Solution {
    Map<String,List<String>> adj = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.putIfAbsent(from,new ArrayList<>());
            adj.get(from).add(to);
        }

        for(Map.Entry<String,List<String>> entry : adj.entrySet()){
            Collections.sort(entry.getValue());
        }
        List<String> res = new ArrayList<>();
        res.add("JFK");
        dfs("JFK",res,tickets.size()+1);

        return res;  
    }

    public boolean dfs(String curr,List<String> res,int targetLen){
        if(res.size()==targetLen){
            return true;
        }

        if(!adj.containsKey(curr)){
            return false;
        }


        List<String> temp = new ArrayList<>(adj.get(curr));

        for(int i = 0;i<temp.size();i++){
            String v = temp.get(i);
            adj.get(curr).remove(i);
            res.add(v);
            if(dfs(v,res,targetLen)){
                return true;
            }
            adj.get(curr).add(i,v);
            res.remove(res.size()-1);   
        }

        return false;
    }
}
