class MinStack {
    Deque<Integer> minStack;
    TreeSet<Integer> treeSet;
    public MinStack() {
        minStack = new ArrayDeque<Integer>(); 
        treeSet = new TreeSet<Integer>();
    }
    
    public void push(int val) {
        this.minStack.addLast(val);
        this.treeSet.add(val);  
    }
    
    public void pop() {
        this.treeSet.remove(this.minStack.removeLast());    
    }
    
    public int top() {
        int top = minStack.removeLast();
        minStack.addLast(top);
        return top;
    }
    
    public int getMin() {
        return treeSet.first();    
    }
}
