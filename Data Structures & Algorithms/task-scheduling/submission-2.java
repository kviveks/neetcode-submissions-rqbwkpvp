class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char ch : tasks){
            freq[ch-'A']++;
        }

        Arrays.sort(freq);

        int maxFreq = freq[25];
        int count = 0;

        for(int i=0;i<=25;i++){
            if(freq[i]==maxFreq){
                count++;
            }
        }

        return Math.max(tasks.length,(maxFreq-1)*(n+1)+count);
    }
}
