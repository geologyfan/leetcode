package swordToOffer;

import java.util.Objects;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/22
 */

public class MaxProductAfterCutting {
    public static void main(String[] args) {
        test a = new test();
        test b = new test();
        a.x = 1;
        a.y= 2;
        b.x=1;
        b.y=3;
        System.out.println(a.hashCode()+"   "+b.hashCode());
        System.out.println(a.equals(b));
    }

    public int solution1(int length){
        if(length<=1)
            return length;
        int[] product = new int[length+1];
        product[1]=1;
        for(int i=2;i<=length;i++){
            int max = 0;
            for(int j=1;j<i-1;j++){
                max=Math.max(max,(j-i)*product[i]);
            }
            product[i]=max;
        }
        return product[length];
    }

}

class test{
    int x;
    int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        test test = (test) o;
        return x == test.x;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
