class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> freqMap = new HashMap<>();

        for(char ch : s.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        

        for(char ch : freqMap.keySet()){
            pq.add(new int[]{ch,freqMap.get(ch)});
        }
        StringBuilder sb = new StringBuilder();
        int[] prev = null;

        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            sb.append((char) curr[0]);
            curr[1]--;


            if(prev!=null && prev[1]!=0){
                pq.add(prev);
            }

            prev = curr;
        }

        if(sb.length()!=s.length())
            return "";

        return sb.toString();
    }
}