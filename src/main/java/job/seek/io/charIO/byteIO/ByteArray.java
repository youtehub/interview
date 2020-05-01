package job.seek.io.charIO.byteIO;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/**
 * 读文件
 *
 * @author yiyh
 */
public class ByteArray {
    public static void main(String[] args) {


        try (
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ) {
            String str = "abc";
            byte[] bytes = str.getBytes();
            System.out.println(Arrays.toString(bytes));
            bos.write(bytes);
            bos.write(bytes);
            bos.close();
            System.out.println(Arrays.toString(bytes));
            System.out.println(bos.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
