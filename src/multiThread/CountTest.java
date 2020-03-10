package multiThread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/5
 */

public class CountTest {
    private static AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        for (Thread thread : threads) {
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        i.getAndIncrement();
                        System.out.println(i);
                    }

                }
            });
            thread.start();
        }
        System.out.println(i);
    }


}
