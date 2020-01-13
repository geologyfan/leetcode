package BinarySearch;

public class MyPow {
    public static void main(String[] args) {

        double x = 0.00001;
        int y = 2147483647;
        System.out.println(new MyPow().myPow(x, y));
    }

    // TODO: 2020/1/8  
    public double myPow(double x, int n) {
        if (n >= 0)
            return helper(x, n);
        else
            return 1 / helper(x, Math.abs(n));
    }

    //这样会超时间
    public double helper(double x, int n) {
        if (n == 0)
            return 1;
        double output = 1;
        while (n > 0) {
            n--;
            output *= x;
        }
        return output;
    }

    //这样会栈溢出
    public double helper2(double x,int n){
        if(x==0){
            return 1;
        }else
            return helper(x,n-1);
    }
}
