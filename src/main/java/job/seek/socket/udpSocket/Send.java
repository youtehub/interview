package job.seek.socket.udpSocket;
import java.io.IOException;
import java.net.*;
public class Send {

    public static void main(String[] args) {
        InetAddress ia=null;
        DatagramSocket ds=null;

        try{
            String mess="你好，我想咨询一个问题。";
            //显示与本地对话框
            System.out.println("我  说："+mess);
            //获取本地主机地址
            ia=InetAddress.getByName("localhost");
            //创建DatagramPacket对象，封装数据
            DatagramPacket dp=new DatagramPacket(mess.getBytes(),mess.getBytes().length ,ia,8800);
            //创建DatagramSocket对象，向服务器发送数据
            ds=new DatagramSocket();
            ds.send(dp);

            byte[] buf=new byte[1024];
            DatagramPacket dpre=new DatagramPacket(buf,buf.length);
            //创建DatagramSocket对象，接收数据
            //ds=new DatagramSocket(8800);
            ds.receive(dpre);
            //显示接收到的信息
            String reply=new String(dpre.getData(),0,dpre.getLength());
            System.out.println(dpre.getAddress().getHostAddress()+"说："+reply);

        }catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //关闭DatagramSocket对象
            ds.close();
        }

    }

}
