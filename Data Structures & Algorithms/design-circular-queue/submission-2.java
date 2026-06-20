class MyCircularQueue {
    int capacity;
    int size;
    int head;
    int tail;
    int[] arr;
    public MyCircularQueue(int k) {
        this.capacity=k;
        arr = new int[k];
        size=0;
        head=0;
        tail=0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        arr[tail]=value;
        tail = (tail+1)%capacity;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        head=(head+1)%capacity;
        size--;
        return true;

    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return arr[head];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return arr[(tail-1+capacity)%capacity];
    }
    
    public boolean isEmpty() {
        if(size==0){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(size==capacity){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */