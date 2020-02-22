package DesignPattern.Singleton;

import com.sun.org.apache.xalan.internal.xsltc.dom.SingleNodeCounter;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/9
 */

public class DoubleCheck {
    public static void main(String[] args) {
//        Single single1 = Single.getInstance();
//        Single single2 = Single.getInstance();
//        System.out.println(single1==single2);
        Thread[] threads = new Thread[200];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Single.getInstance2().hashCode());
                }
            });
            threads[i].start();
        }
    }
}

class Single {
    private static volatile Single single;

    private Single() {
    }

    public static Single getInstance() {
        if (single == null) {
//            synchronized (Single.class) {
//                if (single == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("hahaha im not going to handle this");
                    }

                    single = new Single();
//                }
//            }
        }
        return single;
    }

    private static class Instence{
        private static final Single single = new Single();
    }

    public static Single getInstance2(){
        return Instence.single;
    }
}
