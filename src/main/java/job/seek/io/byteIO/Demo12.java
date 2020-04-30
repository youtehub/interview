package job.seek.io.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 读文件
 *
 * @author yiyh
 */
public class Demo12 {
    public static void main(String[] args) {
        File inputFile = new File("C:\\Users\\Yiuahm\\Desktop\\1.txt");
        File outFile = new File("C:\\Users\\Yiuahm\\Desktop\\3.txt");
        try (
                FileInputStream inputStream = new FileInputStream(inputFile);
                FileOutputStream outputStream = new FileOutputStream(outFile);
        ) {
            byte[] length = new byte[1024];
            int count;
            while ((count = inputStream.read(length)) != -1) {
                outputStream.write(length, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
