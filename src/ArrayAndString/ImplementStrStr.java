package ArrayAndString;

public class ImplementStrStr {
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        int lenOfHaystack = haystack.length();
        int lenOfNeedle = needle.length();
        if (lenOfNeedle == 0) {
            return 0;
        }
        char c = needle.charAt(0);
        for (int i = 0; i < lenOfHaystack; i++) {
            if (haystack.charAt(i) == c) {
                if (lenOfNeedle + i > lenOfHaystack)
                    return -1;
                boolean flag = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    return i;
            }
        }
        return -1;
    }
}
