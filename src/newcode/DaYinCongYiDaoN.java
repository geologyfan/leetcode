package newcode;

import java.util.Arrays;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/12
 */

public class DaYinCongYiDaoN {
    public static void main(String[] args) {


        printNumbers(2);
    }

    public static void printNumbers(int n) {
        char[] numArr = new char[n];
        Arrays.fill(numArr,'0');

        while (!increament(numArr)) {
            int index = 0;
            while(numArr[index]=='0'){
                index++;
            }
            for(int i=index;i<n;i++){
                System.out.print(numArr[i]);
            }
            System.out.print(",");
        }
    }

    private static boolean increament(char[] numArr) {

        boolean flag = false;
        for (int i = numArr.length - 1; i >= 0; i--) {
            char temp = numArr[i];
            if (temp == '9') {
                flag = true;
                numArr[i] = '0';
            } else {
                flag = false;
                numArr[i] += 1;
                break;
            }
        }
        return flag;
    }


}
