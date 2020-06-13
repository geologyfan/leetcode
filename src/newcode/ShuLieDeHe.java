package newcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/10
 */

public class ShuLieDeHe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null && line.length() > 0) {
            String[] nums = line.split(" ");
            int num1 = Integer.parseInt(nums[0]);
            int num2 = Integer.parseInt(nums[1]);
            double res = compute(num1, num2);
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            System.out.println(decimalFormat.format(res));
        }
        br.close();
    }

    private static double compute(int num1, int num2) {
        double sum = 0;
        double num = num1;
        while (num2 > 0) {
            sum += num;
            num = Math.sqrt(num);
            num2--;
        }
        return sum;
    }
}
