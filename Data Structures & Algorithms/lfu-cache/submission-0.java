class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }

    private int capacity;
    private int minFreq;
    private Map<Integer, Node> keyMap;
    private Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) return -1;

        Node node = keyMap.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }

        if (keyMap.size() == capacity) {
            DoublyLinkedList list = freqMap.get(minFreq);
            Node toRemove = list.removeLast();
            keyMap.remove(toRemove.key);
        }

        Node newNode = new Node(key, value);
        keyMap.put(key, newNode);

        freqMap.computeIfAbsent(1, k -> new DoublyLinkedList())
               .addFirst(newNode);

        minFreq = 1;
    }

    private void updateFreq(Node node) {
        int freq = node.freq;
        DoublyLinkedList list = freqMap.get(freq);
        list.remove(node);

        if (freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.freq++;

        freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList())
               .addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */