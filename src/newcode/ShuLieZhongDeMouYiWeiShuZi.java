package newcode;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/12
 */

public class ShuLieZhongDeMouYiWeiShuZi {
    public static void main(String[] args) {
        System.out.println(findNthDigit3(11));
    }

    public static int findNthDigit(int n) {

        if (n < 10) {
            return n;
        }
        int count = 10;
        long i = 10;
        int k = 2;
        while (count + i * 9 * k < n) {
            count += i * 9 * k;
            i *= 10;
            k++;
        }

        n -= count;
        int num = n / k;
        int mod = n % k;
        long temp = i + num;
        String res = Long.toString(temp);
        return res.charAt(mod) - '0';

    }

    public static int findNthDigit2(int n) {
        if(n<10){
            return n;
        }
        int digits = 1;
        int base = 9;
        while (n - base * digits > 0) {
            n -= base * digits;
            base *= 10;
            digits++;
        }
        base = (int) Math.pow(10, digits - 1);
        base += n / digits;
        int index = n % digits;
        String num = Integer.toString(base);
        int res = num.charAt(index) - '0';
        return res;
    }


    public static int findNthDigit3(int n) {
        if(n<10){
            return n;
        }
        n-=10;
        long start = 10;
        int digits = 2;
        while(n>start*digits*9){
            n-=start*digits*9;
            start*=10;
            digits++;
        }
        long num = start+n/digits;
        int index = n%digits;
        String str = Long.toString(num);
        return str.charAt(index)-'0';
    }

}
