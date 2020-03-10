package multiThread;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/5
 */

public class AssemblePointTest {
    static class Tourist extends Thread {
        AssemblPoint ap;

        public Tourist(AssemblPoint ap) {
            this.ap = ap;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " arrived.");
                ap.await();
                System.out.println(Thread.currentThread().getName() + " go!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Tourist[] tourists = new Tourist[10];
        AssemblPoint ap = new AssemblPoint(tourists.length);
        for (Tourist tourist : tourists) {
            tourist = new Tourist(ap);
            tourist.start();
        }
    }

}

class AssemblPoint {
    private int n;

    public AssemblPoint(int n) {
        this.n = n;
    }

    public synchronized void await() throws Exception {
        if (n > 0) {
            n--;
            if (n == 0) {
                notifyAll();
            } else {
                while (n != 0)
                    wait();
            }

        }
    }
}
