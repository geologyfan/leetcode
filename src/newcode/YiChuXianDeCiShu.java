package newcode;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/12
 */

public class YiChuXianDeCiShu {
    public static void main(String[] args) {
        System.out.println(countDigitOne(1000));
    }

    public static int countDigitOne(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }
        //基底是10,0-9内的count是1
        long base = 10;
        long count = 1;

        while (base * 10 - 1 < n) {
            //每当base*10，比如base从10变到100，
            //10到100之间有10个0-9，并有10个1*
            count = 10 * count + base;
            base *= 10;
        }
        //得到最接近的base后，比如123和223和base都是100
        //首先计算最高位有多少个1，
        //比如123的百位上的1个数为24，而223百位上的1的个数为100个
        count += Math.min(base, n - base + 1);
        //然后分别计算完整的部分和不完整的部分，223完整的部分是100-199,
        //不完整的部分是200-223，然后分别计算其中1的个数
        //完整的部分就是递归计算base-1中，223就是0-99中1的个数
        count += (n / base -1) * countDigitOne((int) base - 1);
        //最后不完整的部分即0-23中1的个数
        count += countDigitOne(n % (int) base);
        return (int) count;
    }
}
