package job.seek.io.charIO.byteIO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 读文件
 *
 * @author yiyh
 */
public class Demo5 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Yiuahm\\Desktop\\1.txt");
        try (
                FileReader reader = new FileReader(file)
        ) {
            char[] length = new char[1024];
            int count = 0;
            while ((count = reader.read(length)) != -1) {
                System.out.println(new String(length, 0, count));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
