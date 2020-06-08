package Socket;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/20
 */

public class BaseSocketServer {
    private ServerSocket server;
    private Socket socket;
    private int port;
    private InputStream inputStream;
    private static final int MAX_BUFFER_SIZE = 1024;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public BaseSocketServer(int port) {
        this.port = port;
    }

    public void runServerSingle() throws IOException {
        this.server = new ServerSocket(this.port);
        System.out.println("base socket server started.");
        this.socket = server.accept();
        this.inputStream = this.socket.getInputStream();
        byte[] readBytes = new byte[MAX_BUFFER_SIZE];
        int msgLen;
        StringBuilder stringBuilder = new StringBuilder();
        while ((msgLen = inputStream.read(readBytes)) != -1) {
            stringBuilder.append((new String(readBytes, 0, msgLen, "UTF-8")));
            System.out.println("get message : " + stringBuilder);
            inputStream.close();
            socket.close();
            server.close();
        }

    }

//    public static void main(String[] args) throws Exception{
//       int port = 9899;
//       ServerSocket server = new ServerSocket(port);
//        System.out.println("server started");
//        ExecutorService threadPool = Executors.newFixedThreadPool(100);
//        while(true){
//            Socket socket = server.accept();
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    try{
//                        InputStream inputStream = socket.getInputStream();
//                        byte[] bytes = new byte[1024];
//                        int len;
//                        StringBuilder sb = new StringBuilder();
//                        while((len = inputStream.read(bytes))!=-1){
//                            sb.append(bytes,0,len,"UTF-8");
//                        }
//                    }
//                }
//            }
//        }
//    }
}
