package JVM;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/29
 */

public class ClassInitTest {
    public static void main(String[] args) {
//        System.out.println(subClass.value);
//        subClass[] classes = new subClass[1];
//         System.out.println(superClass.value);
//        System.out.println(subClass.value);
        subClass s = new subClass();
        s.lala();
//        superClass p = s;
//        System.out.println(s==p);
//        System.out.println(s.name);
//        System.out.println(s.value);
//        subClass.haha();
//        s.heihei();
//        System.out.println( p.name);
//        System.out.println(p.value);
//        p.haha();
//        p.heihei();

    }



}

class superClass {
    static {
        System.out.println("superClass init..");
    }

    static  int value = 1;
    String name="super";
    public static void haha(){
        System.out.println("super haha");
    }
    public void heihei(){
        System.out.println("super heihei");
    }

    public void lala(){
        System.out.println("super lala");
        heihei();
    }
}

class subClass extends superClass{
    static {
        System.out.println("subClass init...");
    }
    public  static int value =2;
    String name = "sub";
//    public static void haha(){
//        System.out.println("sub haha");
//    }
    public void heihei(){
        System.out.println("sub heihei");
    }
}
