package job.seek.io.charIO;

import org.junit.Test;

import java.io.*;

/**
 * 读文件
 *
 * @author yiyh
 */
public class BufferedCharOprsTest {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Yiuahm\\Desktop\\1.txt");
        try (
                FileReader reader = new FileReader(file)
        ) {
            char[] length = new char[1024];
            int count;
            while ((count = reader.read(length)) != -1) {
                System.out.println(new String(length, 0, count));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readerFile() {
        File file = new File("C:\\Users\\Yiuahm\\Desktop\\Introduction.txt");
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void writeFile() {
        File file = new File("C:\\Users\\Yiuahm\\Desktop\\Introduction.txt");
        File writeFile = new File("C:\\Users\\Yiuahm\\Desktop\\test.txt");
        try (
                FileReader fileReader = new FileReader(file);
                FileWriter fileWriter = new FileWriter(writeFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void copyPicture() {
        File sourceFile = new File("C:\\TEMP\\myPicture.bmp");
        File targetFile = new File("D:\\myDoc\\myPicture.bmp");
        try (
                FileInputStream fileInputStream = new FileInputStream(sourceFile);
                FileOutputStream fileOutputStream = new FileOutputStream(targetFile);
        ) {
            byte[] length = new byte[1024];
            int count;
            while ((count = fileInputStream.read(length)) != -1) {
                fileOutputStream.write(length,0,count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
