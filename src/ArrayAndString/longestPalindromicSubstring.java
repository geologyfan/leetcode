package Palindrome;

public class longestPalindromicSubstring {
    public static void main(String[] args){
        longestPalindromicSubstring test = new longestPalindromicSubstring();
        System.out.println(test.longestPalindrome_2("bbb"));
    }

    public String longestPalindrome(String s){
        if(s.length()<=1)
            return s;

        int longestLenth = 0;
        int start = 0;

        for(int i = 0;i<s.length()-1;i++){
            for(int j = s.length();(j-i)>longestLenth;j--){
                if(isPalindrome(s.substring(i,j))){
                    start = i;
                    longestLenth = j-i;
                }
            }
        }

        return s.substring(start,start+longestLenth);
    }
     public boolean isPalindrome(String s){
        for(int i = 0;i<(s.length()/2);i++){
            if (s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
     }

     public String longestPalindrome_2(String s){
        int length = s.length();
        int leftOfPalindrome = 0,rightOfPalindrome = 0;
        int lengthOfPalindrome = 0;
        for(int center = 0;center<2*length-1;center++){
            int left=center/2;
            int right = left+center%2;
            int count =0;
            while (left>=0&&right<length&&s.charAt(left)==s.charAt(right)){
                count = right-left+1;
                right++;
                left--;
            }
            if(count>lengthOfPalindrome) {
                lengthOfPalindrome=count;
                leftOfPalindrome = left+1;
                rightOfPalindrome = right-1;
            }
        }
        return s.substring(leftOfPalindrome,rightOfPalindrome+1);
     }
}