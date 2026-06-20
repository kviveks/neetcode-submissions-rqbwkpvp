class MinStack {
    Deque<Integer> stack;
    TreeMap<Integer,Integer> map;
    int min;
    public MinStack() {
        stack = new ArrayDeque<>();
        map = new TreeMap<>();
    }
    
    public void push(int val) {
        stack.addLast(val);
        map.put(val,map.getOrDefault(val,0)+1);  
    }
    
    public void pop() {
        int peek = stack.peekLast();
        stack.removeLast();
        map.put(peek,map.get(peek)-1);
        if(map.get(peek)==0){
            map.remove(peek);
        }
    }
    
    public int top() {
        return stack.peekLast();    
    }
    
    public int getMin() {
        return map.firstKey();    
    }
}
