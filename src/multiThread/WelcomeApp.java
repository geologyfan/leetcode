package multiThread;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/11
 */

public class WelcomeApp {
    public static void  main(String[] args){
        Thread thread1 = new WelcomeThread();
        thread1.start();
        System.out.println(Thread.currentThread().getName());

        Thread thread2  = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("haha i am a thread too");
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread2.start();

        Thread thread4  = new Thread(new HaHaThread("xixi"));
        thread4.start();
        try{
            thread4.join();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

//        Thread.currentThread().join(thread4);thread4
        HaHaThread thread3 = new HaHaThread("lalala");
        thread3.run();
    }
}

class WelcomeThread extends Thread{
    @Override
    public void run() {
        System.out.println("haha im a new thread");
        System.out.println(Thread.currentThread().getName());
    }
}

class HaHaThread implements Runnable{
    private final String message;

    @Override
    public void run() {
        doSomething();
    }

    public HaHaThread(String message){
        this.message=message;
    }

    public void doSomething(){
        System.out.println("haha im "+Thread.currentThread().getName());
    }
}
