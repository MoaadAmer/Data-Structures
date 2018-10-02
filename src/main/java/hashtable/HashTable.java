package hashtable;

import linkedlist.LinkedList;
import linkedlist.Node;

/**
 * Created by MoaadA on 9/25/2018.
 */
public class HashTable<K, V> {

    private final static float MAX_LOAD_FACTOR = 0.7f;
    private LinkedList<KeyValue<K, V>>[] buckets;
    private int totalBuckets = 8;
    private int filledBuckets = 0;

    public HashTable() {
        buckets = new LinkedList[totalBuckets];
    }

    public boolean isEmpty() {

        return filledBuckets == 0;
    }

    public void add(K key, V value) {
        Node<KeyValue<K, V>> found = getNode(key);
        //Already exists -> update its value
        if (found != null) {
            found.getValue().setValue(value);
            return;
        } else {
            filledBuckets++;
            int index = getKeyIndex(key);
            if (buckets[index] == null) {
                buckets[index] = new LinkedList<>();
            }
            buckets[index].addFirst(new KeyValue<>(key, value));
        }

        if (MAX_LOAD_FACTOR >= totalBuckets / filledBuckets) {
            LinkedList<KeyValue<K, V>>[] temp = buckets;
            totalBuckets *= 2;
            filledBuckets = 0;
            buckets = new LinkedList[totalBuckets];
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null) {
                    Node<KeyValue<K, V>> current = temp[i].getHead();
                    while (current != null) {
                        add(current.getValue().getKey(), current.getValue().getValue());
                        current = current.next;
                    }
                }
            }


        }

    }


    public int getSize() {
        return filledBuckets;
    }

    public V get(K key) {
        Node<KeyValue<K, V>> node = getNode(key);
        if (node != null) {
            return node.getValue().getValue();
        }
        return null;
    }

    /**
     * @param key
     * @return the match node by key
     */
    private Node<KeyValue<K, V>> getNode(K key) {

        int index = getKeyIndex(key);
        if (buckets[index] != null) {
            linkedlist.Node<KeyValue<K, V>> current = buckets[index].getHead();
            while (current != null) {
                if (current.getValue().getKey().equals(key))
                    return current;
                current = current.next;
            }
        }
        return null;
    }

    private int getKeyIndex(K key) {
        return ((key.hashCode() % totalBuckets) + totalBuckets) % totalBuckets;
    }


}
