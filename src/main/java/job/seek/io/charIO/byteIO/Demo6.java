package job.seek.io.charIO.byteIO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 读文件
 *
 * @author yiyh
 */
public class Demo6 {
    public static void main(String[] args) {
        File readFile = new File("C:\\Users\\Yiuahm\\Desktop\\1.txt");
        File writeFile = new File("C:\\Users\\Yiuahm\\Desktop\\2.txt");
        try (
                FileReader reader = new FileReader(readFile);
                FileWriter writer = new FileWriter(writeFile);
        ) {
            char[] length = new char[1024];
            int count;
            while ((count = reader.read(length)) != -1) {
                writer.write(length, 0, count);
                System.out.println(new String(length, 0, count));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
