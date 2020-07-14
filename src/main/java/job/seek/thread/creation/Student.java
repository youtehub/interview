package job.seek.thread.creation;


import java.io.*;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.util.Vector;

/**
 * @author Yiuahm
 */
public class Student implements Cloneable {

    //引用类型
    private Subject subject;
    //基础数据类型
    private String name;
    private int age;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

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

    /**
     * 重写clone()方法
     *
     * @return
     */
    @Override
    public Object clone() {
        //深拷贝
        try {
            // 直接调用父类的clone()方法
            Student student = (Student) super.clone();
            student.subject = (Subject) subject.clone();
            return student;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "[Student: " + this.hashCode() + ",subject:" + subject + ",name:" + name + ",age:" + age + "]";
    }
}

class Subject implements Cloneable {

    private String name;

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //Subject 如果也有引用类型的成员属性，也应该和 Student 类一样实现
        return super.clone();
    }

//    @Override
//    public String toString() {
//        return "[Subject: " + this.hashCode() + ",name:" + name + "]";
//    }
}

class TesStu {
    public static void main(String[] args) {
        Vector<Student> v = new Vector(10);

        for (int i = 0; i < 100; i++) {
            Student o = new Student();
            v.add(o);
            o = null;
        }
        v.stream().forEach(System.out::println);
        for (Student st : v) {
            System.out.println(st);
        }

        try {
            InputStream is = new FileInputStream("");
            is.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 强引用
        String strongReference = new String("abc");
        // 软引用
        String str = new String("abc");
        SoftReference<String> softReference = new SoftReference<String>(str);
    }
}