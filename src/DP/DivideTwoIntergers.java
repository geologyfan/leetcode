package DP;

public class DivideTwoIntergers {
    public static void main(String[] args) {
        System.out.println(Math.abs(-2147483648));
    }

    public int divide(int dividend,int divisor){
        if(dividend>=0&&divisor>0){
            return divideHelper(dividend,divisor,1);
        }else if(dividend<=0&&divisor<0){
            return divideHelper(dividend,divisor,-1);
        }else
            return -divideHelper(Math.abs(dividend),Math.abs(divisor),1);
    }

    public int divideHelper(int dividend,int divisor,int flag){
        if((1==flag&&dividend<divisor)||(-1==flag&&dividend>divisor))
            return 0;
        return 1+divideHelper(dividend-divisor,divisor,flag);
    }


}
