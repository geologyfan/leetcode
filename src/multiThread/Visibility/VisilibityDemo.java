package multiThread.Visibility;

import com.sun.deploy.uitoolkit.ToolkitStore;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/12
 */

public class VisilibityDemo {
    public static  void main(String[] args) throws InterruptedException{
        TimeConsumingTask timeConsumingTask = new TimeConsumingTask();
        Thread thread = new Thread(new TimeConsumingTask());
        thread.start();

        Thread.sleep(1000);
        timeConsumingTask.cancel();
    }

}

class TimeConsumingTask implements Runnable{
    private volatile boolean toCancel = false;
    @Override
    public void run() {
        while (!toCancel){
            if(doExecute())
                break;
        }
        if(toCancel){
            System.out.println("Task is canceled");
        }else {
            System.out.println("Task done");
        }
    }

    private boolean doExecute(){
        boolean isDone = false;
        System.out.println("executing...");
        try{
            Thread.sleep(100);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return isDone;
    }

    public void cancel(){
        this.toCancel = true;
        System.out.println(this+" canceled.");
    }
}
