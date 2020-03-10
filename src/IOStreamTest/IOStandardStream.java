package IOStreamTest;

import java.io.*;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/28
 */

public class IOStandardStream {
    public static void main(String[] args) throws IOException {
        File test = new File("I:\\leetcode\\src\\IOStreamTest\\test.txt");
        System.out.println(test.createNewFile());
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(test));
        BufferedWriter bw = new BufferedWriter(out);

        String s;
        while ((s = br.readLine())!=null) {
            if(s.equals("exit"))
                break;
            bw.write(s);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        out.close();
        br.close();
        in.close();



    }


}
