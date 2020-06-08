package Socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/20
 */

public class BaseSocketClient {
    private String serverHost;
    private int serverPort;
    private Socket socket;
    private OutputStream outputStream;

    public BaseSocketClient(String host,int port){
        this.serverHost = host;
        this.serverPort = port;
    }

    public void connectServer() throws IOException{
        this.socket = new Socket(this.serverHost,this.serverPort);
        this.outputStream = socket.getOutputStream();
    }

    public void sendSingle(String message) throws IOException {
        try {
            this.outputStream.write(message.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }
        this.outputStream.close();
        this.socket.close();
    }

    public static void main(String[] args) {
        BaseSocketClient bc = new BaseSocketClient("127.0.0.1",9899);
        try {
            bc.connectServer();
            bc.sendSingle("Hi from mark.");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
