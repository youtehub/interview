package job.seek.socket.SocketDemo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 服务器处理客户端请求的线程
 *
 * @author Administrator
 *
 */
public class LoginThread extends Thread {
    Socket socket = null;

    public LoginThread(Socket socket) {
        this.socket = socket;
    }

    // 处理用户请求
    public void run() {
        try {
            // 3.打开输入流，处理用户请求
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            User user;
            try {
                user = (User) ois.readObject();
                System.out.println("我是服务器，客户端信息为：用户名：" + user.getName()
                        + ",密码：" + user.getPwd());
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            socket.shutdownInput();
            // 服务器给客户端一个响应
            // 1.打开输出流，发送数据
            String info = "欢迎您，登录成功！";
            os.write(info.getBytes());
            // 4.关闭资源

            is.close();
            os.close();
            ois.close();
            socket.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public  void main() {
        int[] aa = {};
    }
}
