class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Integer> radiant = new ArrayDeque<>();
        Deque<Integer> dire = new ArrayDeque<>();
        int n = senate.length();
        for(int i=0;i<senate.length();i++){
            char ch = senate.charAt(i);
            if(ch=='R'){
                radiant.addLast(i);
            }else{
                dire.addLast(i);
            }
        }


        while(!radiant.isEmpty() && !dire.isEmpty()){
            int rIndex = radiant.removeFirst();
            int dIndex = dire.removeFirst();

            if(rIndex<dIndex){
                radiant.addLast(rIndex+n);
            }else{
                dire.addLast(dIndex+n);
            }
        }

        return radiant.isEmpty()?"Dire" : "Radiant";
    }
}