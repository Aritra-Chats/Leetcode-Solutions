class LFUCache {

    private class Node {
        int key, value, freq;
        Node prev, next;
        private Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private class Pair {
        Node head, tail;
        private Pair(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    private Pair createDLL() {
        Node head = new Node(0, 0), tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        return new Pair(head, tail);
    }

    private void insert(Node head, Node node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node; 
    }

    private void remove(Map<Integer, Pair> freqMap, int freq, Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        Pair DLL = freqMap.get(freq);
        if(freq == minFreq && DLL.head.next == DLL.tail) {
            freqMap.remove(freq);
            minFreq++;
        }
    }

    int capacity, minFreq;
    Map<Integer, Node> nodeMap;
    Map<Integer, Pair> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 1;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        remove(freqMap, node.freq, node);
        node.freq++;
        if(!freqMap.containsKey(node.freq)) {
            Node head = new Node(0, 0), tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            freqMap.put(node.freq, createDLL());
        }
        insert(freqMap.get(node.freq).head, node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        if(nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            remove(freqMap, node.freq, node);
            node.freq++;
            if(!freqMap.containsKey(node.freq)) {
                Node head = new Node(0, 0), tail = new Node(0, 0);
                head.next = tail;
                tail.prev = head;
                freqMap.put(node.freq, new Pair(head, tail));
            }
            insert(freqMap.get(node.freq).head, node);
            return;
        }
        if(nodeMap.size() == capacity) {
            Node node = freqMap.get(minFreq).tail.prev;
            remove(freqMap, minFreq, node);
            nodeMap.remove(node.key);
        }
        Node node = new Node(key, value);
        minFreq = 1;
        if(!freqMap.containsKey(minFreq)) {
            Node head = new Node(0, 0), tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            freqMap.put(minFreq, new Pair(head, tail));
        }
        nodeMap.put(key, node);
        insert(freqMap.get(minFreq).head, node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
