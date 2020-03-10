package HashTable;

import java.util.Collection;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/3
 */

public class PriorityQueueTest<T> {
    private PriorityQueue<T> priorityQueue;
    private int k;

    public PriorityQueueTest(int k) {
        this.k = k;
        this.priorityQueue = new PriorityQueue<>(k);
    }

    public void addAll(Collection<T> collection) {
        for (T t : collection) {
            add(t);
        }
    }

    public void add(T t) {
        if (priorityQueue.size() < k) {
            priorityQueue.add(t);
            return;
        }
        Comparable<T> head = (Comparable<T>) priorityQueue.peek();
        if (head.compareTo(t) > 0)
            return;
        priorityQueue.poll();
        priorityQueue.add(t);
    }

    public T getKth() {
        if (priorityQueue.size() < k)
            return null;

        return priorityQueue.peek();
    }

    public <T> T[] toArray(T[] a) {
        return priorityQueue.toArray(a);
    }

}
