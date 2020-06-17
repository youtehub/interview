package job.seek.javasort;

import java.util.Date;

public class NewClass {

    private String name;
    private String password;

    public NewClass() {
    }

    public NewClass(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @SuppressWarnings("unchecked")


    public static void main(String[] args) throws ClassNotFoundException {

        NewClass aClass = new NewClass("天明", "125546");
        System.out.println("第1种方法：Object.getClass()");
        Class c1 = new Date().getClass();// 使用getClass()方式获得Class对象
        System.out.println(c1.getName());// 输出对象名称


        System.out.println("第2种方法：.class语法");
        Class c2 = boolean.class;// 使用.class语法获得Class对象
        System.out.println(c2.getName());// 输出对象名称


        System.out.println("第3种方法：Class.forName()");
        Class c3 = Class.forName("java.lang.String");// 使用Class.forName()获得Class对象
        System.out.println(c3.getName());// 输出对象名称


        createClass();


    }

    public static void createClass() {
        System.out.println("第4种方法：包装类的TYPE域");
        int num = 0;
        Class c4 = Double.TYPE;// 使用包装类获得Class对象
        System.out.println(c4.getName() + num);// 输出对象名称

    }
}

class People extends NewClass {

    private String sex;

    public People(String sex) {
        this.sex = sex;
    }

    public People(String name, String password, String sex) {
        super(name, password);
        this.sex = sex;
    }

    public People() {
    }
}