package linkedlist;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LRUCache {

    class KeyToValue {
        int key;
        int time;

        KeyToValue(int key, int time) {
            this.key = key;
            this.time = time;
        }
    }

    Comparator<KeyToValue> comparator = (c1, c2) -> Integer.compare(c1.time, c2.time);
    PriorityQueue<KeyToValue> queue = new PriorityQueue<>(comparator);
    HashMap<Integer, Integer> map = new HashMap<>();
    int capacity;
    int time = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        System.out.println("capacity:" + capacity);
    }

    public int get(int key) {
        int ans;
        time += 1;

        if (map.get(key) != null) {
            ans = map.get(key);
        } else {
            return -1;
        }

        queue.add(new KeyToValue(key, time));
        System.out.println("get:" + key + ":" + time);

        while (queue.size() > capacity) {
            KeyToValue q = queue.remove();
            if (q.key != key) {
                map.remove(q.key);
                System.out.println("1removed:" + q.key + ":-1");
            }
        }
        System.out.println(map);
        return ans;
    }

    public void put(int key, int value) {

        time += 1;

        if (queue.size() == capacity && !map.containsKey(key)) {
            KeyToValue q = queue.remove();
            map.remove(q.key);
            System.out.println("2removed:" + q.key);
        }

        queue.add(new KeyToValue(key, time));
        System.out.println("put:" + key + ":" + time);
        map.put(key, value);

        System.out.println(map);
    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);
        lruCache.get(2);
        lruCache.put(2, 6);
        lruCache.get(1);
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        lruCache.get(1);
        lruCache.get(2);
    }

}
