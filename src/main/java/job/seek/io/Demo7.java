package job.seek.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 读文件
 *
 * @author yiyh
 */
public class Demo7 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Yiuahm\\Desktop\\1.txt");
        try (
                FileInputStream inputStream = new FileInputStream(file);
        ) {
            int result;
            while ((result = inputStream.read()) != -1) {
                System.out.print(result + "\t");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
