package job.seek.io.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 读文件
 *
 * @author yiyh
 */
public class Demo8 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Yiuahm\\Desktop\\1.txt");
        try (
                FileInputStream inputStream = new FileInputStream(file);
        ) {
            byte[] length = new byte[1024];
            int count;
            while ((count = inputStream.read(length)) != -1) {
                String strings = new String(length, 0, count);
                System.out.print(strings + "\t");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
