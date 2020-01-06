package ArrayAndString;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println("垃圾题目");
    }

    public String countAndSay(int n) {
        if(n==0)
            return "";
        if (n == 1)
            return "1";
        StringBuffer stringBuffer = new StringBuffer();
        String last = countAndSay(n - 1);
        for (int i = 0; i < last.length(); i++) {
            if (last.charAt(i) == '1') {
                if (i < last.length() - 1 && last.charAt(i + 1) == '1') {
                    stringBuffer.append("21");
                    i++;
                } else
                    stringBuffer.append("11");
            } else {
                if (i < last.length() - 1 && last.charAt(i + 1) == '2') {
                    stringBuffer.append("22");
                    i++;
                } else
                    stringBuffer.append("12");
            }
        }
        return stringBuffer.toString();
    }
}
