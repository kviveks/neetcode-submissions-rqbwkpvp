class Solution {
    Map<String,List<String>> adj = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.putIfAbsent(from,new ArrayList<String>());
            adj.get(from).add(to);
        }


        for(Map.Entry<String,List<String>> entry : adj.entrySet()){
            Collections.sort(entry.getValue());
        }
        List<String> res = new ArrayList<>();
        res.add("JFK");
        dfs("JFK",tickets.size()+1,res);

        return res;
    }


    public boolean dfs(String start,int targetLen,List<String> res){
        if(res.size()==targetLen){
            return true;
        }
        
        if(!adj.containsKey(start)){
            return false;
        }


        List<String> temp = new ArrayList<>(adj.get(start));

        for(int i = 0;i<temp.size();i++){
            String v = temp.get(i);
            adj.get(start).remove(i);
            res.add(v);
            if(dfs(v,targetLen,res)){
                return true;
            }
            adj.get(start).add(i,v);
            res.remove(res.size()-1);   
        }

        return false;
    }
}
