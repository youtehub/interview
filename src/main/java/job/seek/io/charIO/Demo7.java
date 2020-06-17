package job.seek.io.charIO;

import java.io.*;

/**
 * 读文件
 *
 * @author yiyh
 */
public class Demo7 {
    public static void main(String[] args) {
        File readFile = new File("C:\\Users\\Yiuahm\\Desktop\\1.txt");
        try (
                BufferedReader reader = new BufferedReader(new FileReader(readFile));

        ) {
            String value;
            while ((value = reader.readLine()) != null) {
                System.out.println(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
