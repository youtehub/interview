package job.seek.io.byteIO;

import org.junit.Test;

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

    @Test
    public void testAdd() {
        byte b;
        b = 3;
        int i = b * 3;
        b = (byte) i;

        float f1 = 100.00f;

        Float F1 = new Float(f1);

        double d1 = F1.doubleValue();//F1.doubleValue()为Float类的返回double值型的方法

//        Integer num1 = 22;
//        int num2 = 22;
//        Long num3 = 22L;
//        System.out.println(num1.equals(num3));
//        System.out.println(num1 == num3);
//        System.out.println(num3.equals(num2));

        int num1 = 100;
        int num2 = 200;
        Long num3 = 300L;
        System.out.println(num3.equals(num1 + num2)); //true
    }
}
