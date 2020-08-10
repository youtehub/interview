package job.seek.socket.udpSocket;
import java.io.IOException;
import java.net.*;
public class Receive {
    public static void main(String[] args) {
        DatagramPacket dp=null;
        DatagramSocket ds=null;
        DatagramPacket dpto=null;
        try{
            //创建DatagramPacket对象，用来准备接收数据包
            byte[] buf=new byte[1024];
            dp=new DatagramPacket(buf,buf.length);
            //创建DatagramSocket对象，接收数据
            ds=new DatagramSocket(8800);
            ds.receive(dp);
            //显示接收到的信息
            String mess=new String(dp.getData(),0,dp.getLength());
            System.out.println(dp.getAddress().getHostAddress()+"说："+mess);

            String reply="你好，我在，请咨询！";
            //显示与本地对话框
            System.out.println("我  说："+reply);

            //创建DatagramPacket对象，封装数据
            SocketAddress sa=dp.getSocketAddress();
            dpto=new DatagramPacket(reply.getBytes(),reply.getBytes().length ,sa);
            ds.send(dpto);

        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            ds.close();
        }
    }
}
