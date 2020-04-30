package job.seek.io.charIO.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
