package multiThread.Visibility;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/12
 */

public class ThreadJoinDemo {
    static int data = 0;
    public static void main(String[] args){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                data ++;
            }
        });
        thread.start();
        try{
            Thread.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println(data);
    }


}
