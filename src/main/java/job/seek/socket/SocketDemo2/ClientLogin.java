package job.seek.socket.SocketDemo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端类
 * @author Administrator
 *
 */
public class ClientLogin {
    public static void main(String[] args) {
        //1.创建一个socket对象（指定服务器IP,端口号）
        try {
            Socket socket = new Socket("localhost",8800);
            //2.打开输出 流,发送请求
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();
            User user = new User();  //创建用来发送的对象
            user.setName("TOM");
            user.setPwd("1234");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(user);
            socket.shutdownOutput();
            //服务器接收客户端反馈
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = "";
            while((info=br.readLine())!=null){
                System.out.println("我是客户端，服务器的响应是："+info);
            }
            os.close();
            is.close();
            oos.close();
            socket.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //3.关闭资源

    }
}
