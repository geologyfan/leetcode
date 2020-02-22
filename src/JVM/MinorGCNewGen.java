package JVM;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/5
 */

public class MinorGCNewGen {
    public static final int _1MB = 1024*1024;
    public static void testAllocation(){
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1=new byte[2*_1MB];
        allocation2=new byte[2*_1MB];
        allocation3=new byte[2*_1MB];
//        System.gc();
        allocation4=new byte[5*_1MB];
        System.gc();
    }
    public static void main(String[] args){
        new MinorGCNewGen();
    }
}
