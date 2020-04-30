package job.seek.io.byteIO;

import org.junit.Test;

import java.io.*;

/**
 * 读文件
 *
 * @author yiyh
 */
public class Demo6 {
    public static void main(String[] args){
        File file = new File("C:\\Users\\Yiuahm\\Desktop\\1.txt");
        try(
                FileInputStream inputStream = new FileInputStream(file)
        ){
            int read = inputStream.read();
            System.out.println(read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
