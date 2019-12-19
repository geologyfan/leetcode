package ArrayAndString;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] test = {"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(test));
    }

    public String longestCommonPrefix(String[] strs) {
        if (0 == strs.length) return "";
        if (0 == strs[0].length()) return "";
        int index = 0;
        for (boolean flag = true; flag; ) {
            if (strs[0].length() < index + 1) {
                flag = false;
                break;
            }
            char tmp = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() < index + 1 || strs[i].charAt(index) != tmp) {
                    flag = false;
                    break;
                }
            }if (flag)
                index++;
        }
        return strs[0].substring(0, index);
    }
}
