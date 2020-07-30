package job.javabBse;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Yiuahm
 * 前期绑定，后期绑定
 */
public class Student {

    private int age;

    private String name;

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private Student init(int age, String name) {
        return new Student(age, name);
    }

    @Test
    public void testLoader(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
    }


    public static void main(String[] args) throws InterruptedException {
        Student student = new Student();
        Student tom1 = student.init(23, "Tom");

        Thread thread = new Thread();
//        thread.sleep(100);
        Thread.sleep(100);
    }

    @Test
    public void testRole() {
        int aa = 11;
        int dd = 22;
        System.out.println(aa + dd);
    }


}

class Test01 {
    public static void main(String[] args) {
        Student student = new Student();
//        Student tom1 = student.init(23, "Tom");
        System.out.println(hash("sdfsdfsdff"));
        Thread.yield();

        List<String> list = new ArrayList<>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String obj = it.next();
            System.out.println(obj);
        }

    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
