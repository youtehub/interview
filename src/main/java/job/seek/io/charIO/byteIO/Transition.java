package job.seek.io.charIO.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 读文件
 *
 * @author yiyh
 */
public class Transition {
    public static void main(String[] args) throws Exception {
        File readFile = new File("");
        InputStreamReader is = new InputStreamReader(new FileInputStream(readFile), "gbk");
        char[] c = new char[1024];
        int value = is.read(c);
        System.out.println(Arrays.toString(c));
    }
}
