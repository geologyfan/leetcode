package swordToOffer;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/22
 */

public class Fibonacci {
    public static void main(String[] args){
        System.out.println(new Fibonacci().compute(3));
    }

    public int compute(int num){
        if(num<=1){
            return num;
        }
        int numPre = 0;
        int numPost= 1;
        int numN=0;
        for(int i=2;i<=num;i++){
            numN = numPre+numPost;
            numPre = numPost;
            numPost = numN;
        }
        return numN;
    }

}
