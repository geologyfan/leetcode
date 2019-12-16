package Palindrome;

public class countPalindromeSubstrings {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(new countPalindromeSubstrings().countPalindromic("aaaaaaaaaaaaa"));
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);
    }

//    public int countPalindromic(String s) {
//        int count = 0;
//        if (s.length() == 0)
//            return 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = s.length(); j > i; j--) {
////                if(s.charAt(i)!=s.charAt(j-1))
////                    continue;
//                if (this.isPalindromic(s.substring(i, j)))
//                    count++;
//            }
//        }
//        return count;
//    }
//
//    public boolean isPalindromic(String s) {
//        for (int i = 0; i < s.length() / 2; i++) {
//            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
//                return false;
//        }
////        System.out.println(s);
//        return true;
//
//    }
    public int countPalindromic(String s){
        int count = 0;
        int left = 0;
        int right = 0;
        int N = s.length();
        for(int center = 0 ;center<2*N-1;center++){
            left = center/2;
            right = center%2 + left;
            while (left>=0&&right<N&&s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}

