package ArrayAndString;

public class PlusOne {
    public static void main(String[] args) {

    }

    public int[] plusOne(int[] digits) {
        int plus = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if ((plus + digits[i]) == 10) {
                digits[i] = 0;
                plus = 1;
            } else {
                digits[i] = plus + digits[i];
                plus = 0;
            }
        }
        if (plus == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; i++)
                newDigits[i] = 0;
            return newDigits;
        }
        return digits;
    }
}
