package job.seek.io.charIO.byteIO;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 读文件
 *
 * @author yiyh
 */
public class Demo9 {
    public static void main(String[] args) {
        List<Student6> list = new ArrayList<>();
        list.add(new Student6("张三", "1001", 18));
        list.add(new Student6("李四", "1002", 19));
        list.add(new Student6("王五", "1003", 20));

        File file = new File("C:\\Users\\Yiuahm\\Desktop\\student.txt");
        try (
                ObjectOutputStream bos = new ObjectOutputStream(new FileOutputStream(file));
        ) {
            bos.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (
                ObjectInputStream bis = new ObjectInputStream(new FileInputStream(file));
        ) {
            List<Student6> list1 = (List<Student6>) bis.readObject();
            Iterator<Student6> iterator = list1.iterator();
            while (iterator.hasNext()) {
                Student6 stu = iterator.next();
                System.out.println("姓名：" + stu.getName() + "\t学号：" + stu.getStuNo() + "\t年龄\t：" + stu.getAge());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Student6 implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 2658878058482366562L;
    private String name;
    private String stuNo;
    private int age;

    public Student6() {
        super();
    }

    public Student6(String name, String stuNo, int age) {
        this.name = name;
        this.stuNo = stuNo;
        this.age = age;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student6 [name=" + name + ", stuNo=" + stuNo + ", age=" + age + "]";
    }
}
