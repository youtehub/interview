package job.seek.socket.SocketDemo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器类
 * @author Administrator
 *
 */
public class ServerLogin {
    public static void main(String[] args) {
        //1.创建一个ServerSocket对象 指定端口号

        ServerSocket serversocket = null;
        try {
            serversocket = new ServerSocket(8800);
            //持续的监听
            while(true){
                Socket socket = serversocket.accept();
                LoginThread loginThread = new LoginThread(socket);
                loginThread.start();  //启动线程，处理客户端请求
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
