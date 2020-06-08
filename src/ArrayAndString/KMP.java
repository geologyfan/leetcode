package ArrayAndString;

/**
 * @description:
 * @author: bin
 * @create: 2020/5/22
 */

public class KMP {
    String pattern;
    int[][] dp;

    public static void main(String[] args){
        KMP kmp = new KMP("abac");
        System.out.println(kmp.search("ababac"));
    }

    public KMP(String pat) {
        this.pattern = pat;
        this.dp = new int[pat.length()][256];

        dp[0][pat.charAt(0)] = 1;
        int X = 0;
        for (int i = 1; i < pat.length(); i++) {
            for (int j = 0; j < 256; j++) {
                dp[i][j] = dp[X][j];
                dp[i][pat.charAt(i)] = i + 1;
            }
            X = dp[X][pat.charAt(i)];
        }
    }

    public int search(String text){
        int stat = 0;
        for(int i=0;i<text.length();i++){
            stat = dp[stat][text.charAt(i)];
            if(stat==pattern.length()){
                return i-pattern.length()+1;
            }
        }
        return -1;
    }
}
