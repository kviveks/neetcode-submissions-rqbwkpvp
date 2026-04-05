class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] res = new int[temp.length];
        // We use the Deque as a Stack
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < temp.length; i++) {
            // While the current temperature is warmer than the temperature 
            // at the index on top of the stack:
            while (!stack.isEmpty() && temp[i] > temp[stack.peekLast()]) {
                int prevIndex = stack.removeLast(); // This is the 'pop'
                res[prevIndex] = i - prevIndex;     // Calculate the distance
            }
            // Always push the current index onto the stack
            stack.addLast(i); 
        }  
        return res;  
    }
}