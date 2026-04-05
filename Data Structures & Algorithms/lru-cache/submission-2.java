class Node {
    int key;
    int value;
    Node previous;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    Map<Integer,Node> nodeMap;
    int capacity;
    Node head;
    Node last;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();

        head = new Node(-1,-1);
        last = new Node(-1,-1);

        head.next = last;
        last.previous = head;
    }

    public int get(int key) {

        Node node = nodeMap.get(key);

        if(node == null) return -1;

        remove(node);
        add(node);

        return node.value;
    }

    public void put(int key, int value) {

        if(nodeMap.containsKey(key)) {

            Node existing = nodeMap.get(key);
            existing.value = value;

            remove(existing);
            add(existing);

            return;
        }

        Node node = new Node(key,value);

        nodeMap.put(key,node);
        add(node);

        if(nodeMap.size() > capacity) {

            Node lru = last.previous;

            remove(lru);
            nodeMap.remove(lru.key);
        }
    }

    private void add(Node node){

        Node temp = head.next;

        head.next = node;
        node.previous = head;

        node.next = temp;
        temp.previous = node;
    }

    private void remove(Node node){

        node.previous.next = node.next;
        node.next.previous = node.previous;
    }
}
