package job.javabBse;


import org.junit.Test;

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

    private Student init(int age, String name){
        return new Student(age, name);
    }

    @Test
    public void testLoader(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
    }


    public static void main(String[] args) {
        Student student = new Student();
        Student tom1 = student.init(23, "Tom");
    }
}

class Test01{
    public static void main(String[] args) {
        Student student = new Student();
//        Student tom1 = student.init(23, "Tom");
    }
}
