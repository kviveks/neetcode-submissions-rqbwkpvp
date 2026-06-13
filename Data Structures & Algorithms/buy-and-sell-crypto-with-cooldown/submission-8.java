class Solution {
    public int maxProfit(int[] prices) {

        int sold = 0;
        int cooldown = 0;
        int hold = -prices[0];



        for(int i=1;i<prices.length;i++){

            int prevhold = hold;
            int prevsold = sold;
            int prevcooldown = cooldown;


            hold = Math.max(prevhold,prevcooldown-prices[i]);
            cooldown = Math.max(prevcooldown,prevsold);
            sold = prevhold+prices[i];
        }


        return Math.max(cooldown,sold);
        
    }
}
