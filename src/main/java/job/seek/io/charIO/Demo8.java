package job.seek.io.charIO;

import java.io.*;

/**
 * 读文件
 *
 * @author yiyh
 */
public class Demo8 {
    public static void main(String[] args) {
        File readFile = new File("C:\\Users\\Yiuahm\\Desktop\\1.txt");
        File writeFile = new File("C:\\Users\\Yiuahm\\Desktop\\2.txt");
        try (
                BufferedReader reader = new BufferedReader(new FileReader(readFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile));
        ) {
            String value;
            while ((value = reader.readLine()) != null) {
                System.out.println(value);
                writer.write(value);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
