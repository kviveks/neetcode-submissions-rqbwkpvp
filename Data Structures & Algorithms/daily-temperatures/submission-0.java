class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int l = temp.length;
        int[] res = new int[l];
        Stack<Integer> stack = new Stack<>();
        stack.add(l-1);


        for(int i = l-2;i>=0;i--){
            while(!stack.isEmpty() && temp[stack.peek()]<temp[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i]=0;
            }else{
                res[i]=stack.peek()-i;
            }
            stack.add(i);
        }

        return res;

    }
}
