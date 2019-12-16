package Palindrome;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeating().lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int tempLength = 0;
        int longestLength = 0;

        char temp;
        int i;
        Map<Character, Integer> hashMap = new HashMap<>();
        for (i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if (hashMap.containsKey(temp)&&hashMap.get(temp)>=start) {
                longestLength = (i - 1 - start + 1) > longestLength ? (i - 1 - start + 1) : longestLength;
                start = hashMap.get(temp) + 1;
                hashMap.put(temp, i);
            } else {
                hashMap.put(temp, i);
            }
        }
        longestLength = (i - 1 - start + 1) > longestLength ? (i - 1 - start + 1) : longestLength;
        return longestLength;
    }
}
