package HashTable;

import java.util.*;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/3
 */

public class GetMid<T> {
    private PriorityQueue<T> bigHeap;
    private PriorityQueue<T> smallHeap;
    private T mid;

    public static void main(String[] args){

    }

    public GetMid() {
        bigHeap = new PriorityQueue<>();
        smallHeap = new PriorityQueue<>(11, Collections.reverseOrder());
    }

    public int compare(T t1, T t2) {
        Comparable<? super T> cmpr = (Comparable<? super T>) t1;
        return cmpr.compareTo(t2);
    }

    public void addAll(Collection<T> collection) {
        for (T t : collection) {
            add(t);
        }
    }

    public void add(T t) {
        if (null == mid)
            mid = t;

        if (compare(t, mid) > 0) {
            bigHeap.add(t);
        } else {
            smallHeap.add(t);
        }

        if (bigHeap.size() - smallHeap.size() >= 2) {
            smallHeap.add(mid);
            this.mid = bigHeap.poll();
        } else if (smallHeap.size() - bigHeap.size() >= 2) {
            bigHeap.add(mid);
            mid = smallHeap.poll();
        }
    }

    public T getMid() {
        return this.mid;
    }

}
