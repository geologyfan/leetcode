package ArrayAndString;

import java.util.HashMap;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/25
 */

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (charMap.containsKey(t.charAt(i))) {
                charMap.put(t.charAt(i), charMap.get(t.charAt(i)) + 1);
            } else {
                charMap.put(t.charAt(i), 1);
            }
        }

        int low = 0, high = 0;
        String minSubstring = "";
        int minLength = s.length();

        while (high < s.length()) {
            high = expand(s, low, high, charMap);
            if (high < s.length()) {
                low = shrink(s, low, high, charMap);
                if ((high - (low - 1) + 1) <= minLength) {
                    minLength = high - (low - 1) + 1;
                    minSubstring = s.substring(low - 1, high + 1);

                }
                high++;
            }
        }
        return minSubstring;

    }

    public int expand(String s, int low, int high, HashMap<Character, Integer> charMap) {
        while (high < s.length()) {
            if (charMap.containsKey(s.charAt(high))) {
                charMap.put(s.charAt(high), charMap.get(s.charAt(high)) - 1);
                if (judgeMap(charMap))
                    return high;
            }
            high++;
        }
        return high;
    }

    public int shrink(String s, int low, int high, HashMap<Character, Integer> charMap) {
        while (low<s.length()) {
            if (charMap.containsKey(s.charAt(low))) {
                charMap.put(s.charAt(low), charMap.get(s.charAt(low)) + 1);
                if (charMap.get(s.charAt(low)) > 0)
                    return low+1 ;
            }
            low++;
        }

        return low;
    }

    public boolean judgeMap(HashMap<Character, Integer> charMap) {

        for (Character character : charMap.keySet()) {
            if (charMap.get(character) > 0)
                return false;
        }
        return true;
    }

}
