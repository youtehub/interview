package job.seek.thread;

import java.util.Random;

/**
 * @author Yiuahm
 */
public class ThreadLocalTest implements Runnable {
    ThreadLocal<Student> studenThreadLocal = new ThreadLocal<Student>();

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + " is running...");
        Random random = new Random();
        int age = random.nextInt(100);
        System.out.println(currentThreadName + " is set age: " + age);
        Student student = getStudent(); //通过这个方法，为每个线程都独立的 new 一个 student 对象，每个线程的的
//        student 对象都可以设置不同的值
        student.setAge(age);
        System.out.println(currentThreadName + " is first get age: " + student.getAge());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(currentThreadName + " is second get age: " + student.getAge());
    }

    private Student getStudent() {
        Student student = studenThreadLocal.get();
        if (null == student) {
            student = new Student();
            studenThreadLocal.set(student);
        }
        return student;
    }

    public static void main(String[] args) {
        ThreadLocalTest t = new ThreadLocalTest();
        Thread t1 = new Thread(t, "Thread A");
        Thread t2 = new Thread(t, "Thread B");
        t1.start();
        t2.start();
    }
}

class Student {
    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}