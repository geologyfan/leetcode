package newcode;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/8
 */

public class TongPeiFu {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String pattern = sc.nextLine();
//        String str = sc.nextLine();
//        match(pattern, str);
//        sc.close();
        String p = "o*m";
        String str = "shopeemobile.com";
        match(p, str);
    }

    private static void match(String pattern, String str) {
        pattern = pattern.replaceAll("\\*", "\\.\\*\\?");
        pattern = "\\^" + pattern;
        Pattern p = Pattern.compile(pattern);
//        for (int i = 0; i < str.length(); i++) {
//            for (int j = i + 1; j <= str.length(); j++) {
//                Matcher m = p.matcher(str.substring(i, j));
//                if (m.matches()) {
//                    System.out.println(i + " " + (j-i));
//                }
//            }
//        }
        Matcher m = p.matcher(str.substring(1));

        int i = 0;
        while (m.find()) {
//            while(m.find()){
            System.out.println(m.start() + " " + (m.end() - m.start()));
//            }

        }

    }

}
