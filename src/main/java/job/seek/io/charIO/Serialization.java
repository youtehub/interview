package job.seek.io.charIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 读文件
 *
 * @author yiyh
 */
public class Serialization {
    public static void main(String[] args) {
        List<Teacher> list = new ArrayList<>();
        list.add(new Teacher(" 张三 ", 18, new ClassRoom("0318java")));
        list.add(new Teacher(" 李四 ", 18, new ClassRoom("0318java")));
        list.add(new Teacher(" 王五 ", 18, new ClassRoom("0318java")));
        writeToFile(list, "C:\\Users\\Yiuahm\\Desktop\\stu.txt");
// 读取
        System.out.println(readTeacher("C:\\Users\\Yiuahm\\Desktop\\stu.txt"));
    }

    public static void writeToFile(List<Teacher> list, String fileName) {
        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
        ) {
            output.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Teacher>  readTeacher(String fileName){
        List<Teacher> teacherslist = null;
        try (
                ObjectInputStream output = new ObjectInputStream(new FileInputStream(new File(fileName)));
        ) {
            teacherslist = (List<Teacher>) output.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacherslist;
    }
}

class Teacher implements Serializable {
    /**
     * 序列化版本号：默认版本号为 1l
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private ClassRoom cn;// 班级

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ClassRoom getCn() {
        return cn;
    }

    public void setCn(ClassRoom cn) {
        this.cn = cn;
    }

    @Override
    public String toString() {
        return "Teacher [name=" + name + ", age=" + age + ", cn=" + cn + "]";
    }

    public Teacher() {
        super();
// TODO Auto-generated constructor stub
    }

    public Teacher(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Teacher(String name, int age, ClassRoom cn) {
        super();
        this.name = name;
        this.age = age;
        this.cn = cn;
    }
}

class ClassRoom implements Serializable {
    /**
     * 序列化版本号：保证序列化流与反序列化流读写一致
     */
    private static final long serialVersionUID = 3359646767342429683L;
    private String no;

    public ClassRoom() {
        super();
    }

    public ClassRoom(String no) {
        super();
        this.no = no;
    }

    @Override
    public String toString() {
        return "ClassRoom [no=" + no + "]";
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }// 班级号码
}