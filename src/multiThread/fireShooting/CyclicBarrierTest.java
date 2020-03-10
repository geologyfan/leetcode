package multiThread.fireShooting;

import java.util.concurrent.CyclicBarrier;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/5
 */

public class CyclicBarrierTest {
    static class Tourist extends Thread {
        CyclicBarrier cyclicBarrier;

        public Tourist(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep((int) Math.random() * 1000);
                System.out.println(Thread.currentThread().getName() + " arrived A at " + System.currentTimeMillis());
                cyclicBarrier.await();
                Thread.sleep((int) Math.random() * 1000);
                System.out.println(Thread.currentThread().getName() + " arrived B at " + System.currentTimeMillis());
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int num = 10;
        Tourist[] tourists = new Tourist[num];
        CyclicBarrier cyclicBarrier = new CyclicBarrier(num, new Runnable() {
            @Override
            public void run() {
                System.out.println("all arrived by " + Thread.currentThread().getName());
            }
        });

        for (Tourist tourist : tourists) {
            tourist = new Tourist(cyclicBarrier);
            tourist.start();
        }
    }

}
