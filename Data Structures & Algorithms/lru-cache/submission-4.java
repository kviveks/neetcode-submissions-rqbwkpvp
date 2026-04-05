class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}


class LRUCache {
    Map<Integer,Node> nodeMap;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        nodeMap = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {

        Node node = nodeMap.get(key);

        if(node==null) return -1;

        remove(node);
        add(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {

        if(nodeMap.containsKey(key)){
            Node existing = nodeMap.get(key);
            existing.value = value;

            remove(existing);
            add(existing);

            return;
        }  


        Node node = new Node(key,value);
        nodeMap.put(key,node);
        add(node);

        if(nodeMap.size()>capacity){
            Node lru = tail.prev;

            remove(lru);
            nodeMap.remove(lru.key);
        }  
    }

    public void add(Node node){
        Node temp = head.next;
        
        head.next = node;
        node.prev = head;

        node.next = temp;
        temp.prev = node;
    }


    private void remove(Node node){

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
