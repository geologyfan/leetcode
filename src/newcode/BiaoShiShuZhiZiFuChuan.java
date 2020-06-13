package newcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/12
 */

public class BiaoShiShuZhiZiFuChuan {
    public static void main(String[] args) {
        System.out.println(isNumber("-5e2"));
    }

    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.trim();
        int len = s.length();
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        for (int i = 0; i < len; i++) {
            char temp = s.charAt(i);
            if (temp >= '0' && temp <= '9') {
                numSeen = true;
            } else if (temp == '.') {
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (temp == 'e') {
                if (!numSeen || eSeen) {
                    return false;
                }
                eSeen = true;
                numSeen = false;
            } else if (temp == '+' || temp == '-') {
                if (numSeen && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }

            } else {
                return false;
            }
        }
        return numSeen;
    }
}
