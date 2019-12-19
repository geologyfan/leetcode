package ArrayAndString;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(58));
    }

    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer("");
        int numOfM = num / 1000;
        for (int i = 0; i < numOfM; i++)
            roman.append("M");
        num %= 1000;
        num = helper(roman, num, 100, "CM", "D", "CD", "C");
        num = helper(roman, num, 10, "XC", "L", "XL", "X");
        num = helper(roman, num, 1, "IX", "V", "IV", "I");
        return roman.toString();
    }

    public int helper(StringBuffer roman, int num, int time, String nine, String five, String four, String one) {
        if (num < time) {
            return num;
        }
        if (num >= 5 * time) {
            if (9 == num / time) {
                roman.append(nine);
                num -= 9 * time;
            } else {
                roman.append(five);
                num -= 5 * time;
            }
        }
        if (4 == num / time) {
            roman.append(four);
            num -= 4 * time;
        } else {
            int numOfTime = num / time;
            for (int i = 0; i < numOfTime; i++)
                roman.append(one);
            num %= time;

        }
        return num;
    }
}
