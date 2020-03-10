package IOStreamTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/27
 */

public class Traversal {
    public static void main(String[] args) {
//        Traversal traversal =new Traversal();
//        File dir = new File("G:\\aa\\bb\\cc");
//        dir.mkdirs();
//        traversal.copyFile("G:\\nmt_server.zip","G:\\aa\\bb\\cc\\nmt_server.zip");
        String message = "heiha";
        String a  = "hei"+"ha";
        String b = "hei";
        String c = "ha";
        String d = b+c;
        String e = new String("heiha");
        System.out.println(message==a);
        System.out.println(message==e);
        System.out.println(d==message);
        String f = b+"ha";
        System.out.println(message==f);

    }

    public void printFile(File file) {
        String[] fileList = file.list();
        for (String s : fileList) {
            File tempFile = new File(file.getAbsolutePath() + File.separator + s);
            System.out.println(tempFile.getName());
            if (tempFile.isDirectory()) {
                printFile(tempFile);
            }
        }
    }

    public void copyFile(String file1, String file2) {
        try {
            FileInputStream in = new FileInputStream(file1);
            FileOutputStream out = new FileOutputStream(file2);
            byte[] bytes = new byte[100];
            int len = 0;
            while((len=in.read(bytes))!=-1){
                out.write(bytes,0,len);
            }
            out.flush();
            in.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
