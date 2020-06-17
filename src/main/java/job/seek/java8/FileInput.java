package job.seek.java8;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * Lambda表达式
 *
 * @author yiyh
 */
public class FileInput {
    // level用来记录当前递归的层次

    public static void listChilds(File f, int level) {
        // 生成有层次感的空格
        StringBuffer sb = new StringBuffer("|--");
        for (int i = 0; i < level; i++) {
            sb.insert(0, "| ");
        }
        File[] childs = f.listFiles();
        // 递归出口
        int length = childs == null ? 0 : childs.length;
        for (int i = 0; i < length; i++) {
            System.out.println(sb.toString() + childs[i].getName());
            if (childs[i].isDirectory()) {
                listChilds(childs[i], level + 1);
            }
        }
    }

    // FileOutputStream 类的使用：将内容写入文件
    class A2 {
        @Test
        public void main(String[] args) {
            A2 a2 = new A2();
            //电脑d盘中的abc.txt 文档
            String filePath = "D:/abc.txt";
            //要写入的内容
            String content = "今天是2017/1/9,天气很好";
            a2.writeFile(filePath, content);
        }

        /**
         * 根据文件路径创建输出流
         *
         * @paramfilePath ： 文件的路径
         * @paramcontent : 需要写入的内容
         */
        public void writeFile(String filePath, String content) {
            FileOutputStream fos = null;
            try {
                //1、根据文件路径创建输出流
                fos = new FileOutputStream(filePath);
                //2、把string转换为byte数组；
                byte[] array = content.getBytes();
                //3、把byte数组输出；
                fos.write(array);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Test
    public void testLinkedHashMap() {
        LinkedHashMap map = new LinkedHashMap<>(16);
        map.put(1, "weather");
        String word = (String) map.get(1);
        System.out.println(word);
    }

    @Test
    public void testBasicType() {
        byte bytes = 127;
        int sum = 12 + bytes;
        float sum1 = sum;
        double d = sum1;
        char c = 'c';
        int i = c;
        Double D1 = 12.01;
        //自动装箱
        Integer total = 99;
        //自动拆箱
        int totalprim = total;
        System.out.println(sum);
    }
}
