/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/

// This is mainly a practice for doubly linkedly list

public class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-2, -2);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        node.pre.next = node.next;
        node.next.pre  = node.pre;
        attach(node);
        return node.value;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            node.pre.next = node.next;
            node.next.pre = node.pre;
            attach(node);
        } else {
            if(map.size() == this.capacity)
                dettach();
            Node node = new Node(key, value);
            attach(node);
            map.put(key, node);
        }
    }
    
    public void attach(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }
    
    public void dettach() {
        Node last = tail.pre;
        tail.pre = tail.pre.pre;
        last.pre.next = tail;
        map.remove(last.key);
    }
    
    private class Node {
        public int key;
        public int value;
        public Node next = null;
        public Node pre = null;
        
        Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }
}