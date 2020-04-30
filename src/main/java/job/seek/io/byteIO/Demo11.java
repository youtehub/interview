package job.seek.io.byteIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 读文件
 *
 * @author yiyh
 */
public class Demo11 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Yiuahm\\Desktop\\3.txt");
        try (
                FileOutputStream outputStream = new FileOutputStream(file);
        ) {
            String notes = "没有绝对的绝缘体，只有不努力的电压。";
            outputStream.write(notes.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
