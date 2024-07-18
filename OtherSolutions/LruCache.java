package assesmentsolutions;
import java.util.HashMap;
class LruCache {

    private class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);  
        this.tail = new Node(0, 0);  
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insertToFront(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insertToFront(node);
        } else {
            if (map.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertToFront(newNode);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {
        LruCache cache = new LruCache(2);

        cache.put(1, 1); //insert 1
        cache.put(2, 2); //insert 2
        System.out.println(cache.get(1)); //return 1
        cache.put(3, 3); //insert 3 and remove 2
        System.out.println(cache.get(2)); //return -1
        cache.put(4, 4); //insert 4 and remove 1
        System.out.println(cache.get(1)); //return -1
        System.out.println(cache.get(3)); //return 3
        System.out.println(cache.get(4)); //return 4
    }
}