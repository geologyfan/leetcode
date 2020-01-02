package ArrayAndString;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("))))())()()(()"));
    }

    //TODO 待解决
    public int longestValidParentheses(String s) {
        return Math.min(left(s), right(s));
    }

    public int left(String s) {

        Stack<Character> bracketStack = new Stack<>();
        int maxLen = 0;
        int tempLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                bracketStack.push('(');
            else if (s.charAt(i) == ')') {
                if (!bracketStack.empty()) {
                    tempLen += 2;
                    bracketStack.pop();
                } else {
                    maxLen = Math.max(tempLen, maxLen);
                    tempLen = 0;
                }
            }
        }
        maxLen = Math.max(tempLen, maxLen);
        return maxLen;
    }

    public int right(String s) {
        Stack<Character> bracketStack = new Stack<>();
        int maxLen = 0;
        int tempLen = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')')
                bracketStack.push(')');
            else if (s.charAt(i) == '(') {
                if (!bracketStack.empty()) {
                    tempLen += 2;
                    bracketStack.pop();
                } else {
                    maxLen = Math.max(tempLen, maxLen);
                    tempLen = 0;
                }
            }
        }
        maxLen = Math.max(tempLen, maxLen);
        return maxLen;
    }
}
