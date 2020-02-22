package swordToOffer;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/22
 */

public class RegularMatch {
    public static void main(String[] args) {
        System.out.println(new RegularMatch().match("a", "a*b*"));
    }

    public boolean match(String str, String pattern) {
        return helper(str, 0, pattern, 0);
    }

    public boolean helper(String str, int indexStr, String pattern, int indexPattern) {
        if (indexStr >= str.length() && indexPattern >= pattern.length()) {
            return true;
        } else if (indexStr < str.length() && indexPattern >= pattern.length()) {
            return false;
        } else if (indexStr >= str.length()) {
            if (indexPattern <= pattern.length() - 2 && pattern.charAt(indexPattern + 1) == '*')
                return helper(str, indexStr, pattern, indexPattern + 2);
            else
                return false;
        } else if (indexPattern < pattern.length() - 1 && pattern.charAt(indexPattern + 1) == '*') {
            if (pattern.charAt(indexPattern) == '.' || str.charAt(indexStr) == pattern.charAt(indexPattern)) {
                return helper(str, indexStr + 1, pattern, indexPattern) || helper(str, indexStr, pattern, indexPattern + 2);
            } else {
                return helper(str, indexStr, pattern, indexPattern + 2);
            }
        } else if (pattern.charAt(indexPattern) == '.' || str.charAt(indexStr) == pattern.charAt(indexPattern)) {
            return helper(str, indexStr + 1, pattern, indexPattern + 1);
        } else
            return false;
    }
}
