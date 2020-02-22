package JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/8
 */

public class ReloadTest {
//    public static String method(List<String> list) {
//        System.out.println("invoke List<String>");
//        return "";
//    }
//    public static int method(List<Integer> list){
//        System.out.println("invoke List<Integer>");
//        return 1;
//    }
//    public static void main(String[] args){
//        method(new ArrayList<String>());
//        method(new ArrayList<Integer>());
//    }
//    public static void main(String[] args){
//        Integer a = 1;
//        Integer b = 2;
//        Integer c = 3;
//        Long g = 3L;
//        System.out.println(a==b);
//        System.out.println(c==(a+b));
//        System.out.println(c.equals(b+a));
//        System.out.println(g.equals(a+b));
//        System.out.println(g==(a+b));
//    }

    static class Human{
        void speak(){
            System.out.println("i am human");
        }
    }

    static class Man extends Human{
        @Override
        void speak() {
            System.out.println("i am man");
        }
    }

    static class Woman extends Human{
        void speak(){
            System.out.println("i am woman");
        }
    }

     void tell(Human human){
        System.out.println("you are human");
    }

    void tell(Man man){
        System.out.println("you are man");
    }

    void tell(Woman woman){
        System.out.println("you are woman");
    }


    public static void main(String[] args){
        ReloadTest test = new ReloadTest();
        Human man = new Man();
        Human woman = new Woman();

        test.tell(man);
        test.tell(woman);
        man.speak();
        woman.speak();
        test.tell(new Man());
    }
}
