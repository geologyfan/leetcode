package Palindrome;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(new Palindrome.PalindromeNumber().isPalindrome_2(12121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        String s = String.valueOf(x);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }

    public boolean isPalindrome_2(int x) {
        if (x < 0||(x>=10&&x%10==0))
            return false;
        if(x==0)
            return true;
        int num_reverse = 0;
        while (x > 0) {
            num_reverse = num_reverse * 10 + x % 10;
            if (x == num_reverse || num_reverse == x / 10)
                return true;
            x = x / 10;
        }
        return false;
    }
}