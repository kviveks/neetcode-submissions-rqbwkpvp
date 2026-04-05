class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        int a,b;
        int res;
        for(int i = 0; i<tokens.length; i++){
            if(tokens[i].equals("+")){
                b=stack.pop();
                a=stack.pop();
                res = a+b;
                stack.push(res);
            }else if(tokens[i].equals("-")){
                b=stack.pop();
                a=stack.pop();
                res = a-b;
                stack.push(res);
            }else if(tokens[i].equals("*")){
                b=stack.pop();
                a=stack.pop();
                res = a*b;
                stack.push(res);
            }else if(tokens[i].equals("/")){
                b=stack.pop();
                a=stack.pop();
                res = a/b;
                stack.push(res);
            }else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }

        return stack.pop();
        
    }
}
