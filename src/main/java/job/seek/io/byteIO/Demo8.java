package job.seek.io.byteIO;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        List list = new ArrayList<>();
        list.add(33);
        list.add("2343");

        Integer[] aa = {1,3};
        char[] chars = {'3'};

    }

    @Test
    public void loadClass(){
        try {
            Class<?> aClass = Class.forName("job.seek.io.byteIO.Demo7");
            Class<?> bClass = Class.forName("job.seek.io.byteIO.Demo7");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
