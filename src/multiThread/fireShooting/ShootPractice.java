package multiThread.fireShooting;

import jdk.nashorn.internal.runtime.Debug;

import java.util.concurrent.CyclicBarrier;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/15
 */

public class ShootPractice {
    final Soldier[][] rank;//所有的士兵
    final int N;//每排士兵的人数，也是靶子的数量
    final int lasting;//打靶持续时间
    volatile boolean done = false;//标识是否继续打靶
    volatile int nextLine = 0;//标识下一轮打靶的士兵是哪一排
    final CyclicBarrier startBarrier;
    final CyclicBarrier shiftBarrier;

    public ShootPractice(int N, int lineCount, int lasting) {
        this.N = N;
        this.lasting = lasting;
        rank = new Soldier[lineCount][N];
        for (int i = 0; i < lineCount; i++) {
            for (int j = 0; j < N; j++)
                rank[i][j] = new Soldier(i * N + j);
        }
        shiftBarrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                nextLine = nextLine + 1;
                if(nextLine==lineCount){
                    done = true;
                }
//                try{
//                    Thread.sleep(0);
//                }catch (Exception e){
//
//                }
                System.out.println("Next turn is : " + nextLine);
            }
        });

        startBarrier = new CyclicBarrier(N);
    }

    public static void main(String[] args) {
        ShootPractice sp = new ShootPractice(4, 5, 20);
        sp.start();
    }

    public void start() {
        if(done){
            System.out.println("Shooting done!!");
            return;
        }
        Thread[] threads = new Thread[N];
        for (int i = 0; i < N; i++) {
            threads[i] = new Shooting(i);
            threads[i].start();
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (Exception e) {

            }
        }
    }


    class Shooting extends Thread {
        final int index;

        public Shooting(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            Soldier soldier;
            try {
                while (!done) {
                    soldier = rank[nextLine][index];
//                    startBarrier.await();
                    soldier.fire();
                    shiftBarrier.await();
                }
//                System.out.println("shooting done!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


class Soldier {
    final int num;

    public Soldier(int num) {
        this.num = num;
    }

    public void fire() {
        System.out.println(System.currentTimeMillis() + " " + Thread.currentThread() + " Soldier-" + num + " fire, biu~ biu~");
    }
}
