class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {

            if (token.equals("+")) {
                int b = stack.removeLast();
                int a = stack.removeLast();
                stack.addLast(a + b);

            } else if (token.equals("-")) {
                int b = stack.removeLast();
                int a = stack.removeLast();
                stack.addLast(a - b);

            } else if (token.equals("*")) {
                int b = stack.removeLast();
                int a = stack.removeLast();
                stack.addLast(a * b);

            } else if (token.equals("/")) {
                int b = stack.removeLast();
                int a = stack.removeLast();
                stack.addLast(a / b);   // integer division

            } else {
                stack.addLast(Integer.parseInt(token));
            }
        }

        return stack.removeLast();
    }
}
