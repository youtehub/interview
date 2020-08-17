package job.javabBse;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Yiuahm
 * 前期绑定，后期绑定
 */
public class Father {
    protected String name = "父亲属性";

    public Father() {
    }

    public Father(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void introduce() {
        System.out.println("我是父亲 ,今年46岁，很高兴认识大家！");
    }

    @Test
    public void testArray() {
        int[] arr = new int[5];
        Arrays.stream(arr).forEach(System.out::println);
    }

    @Test
    public void test02(){
        List<Object> list = new ArrayList<Object>();
        list.add("123");
        list.add(new Integer(0));
        //指定list中存储的元素类型
        Class type = String.class;
        List checkedList = Collections.checkedList(list, type);
        checkedList.add("hello");
        checkedList.add("hello");
        System.out.println(checkedList);
        //输出结果:[123, 0, hello]


    }

}

class Son extends Father {
    protected String name = "儿子属性";

    public static final Integer NUMBER = 3;

    public static List<Long> dd = new ArrayList<>();

    public Son() {
    }

    public Son(String name) {
        super(name);
    }

    public Son(String fname, String name) {
        super(fname);
        this.name = name;
    }

    static {
        dd.add(23L);
        dd.add(13L);
        dd.add(223L);
        dd.add(79L);
    }


    @Override
    public String getName() {
        return name;
    }

    public static void introduce() {
        System.out.println("我是儿子,今年21岁，很高兴认识大家！");
    }

    public static void main(String[] args) {
        Father sample = new Son();
//        System.out.println("调用的属性：" + sample.name);
//        System.out.println("调用的属性:" + sample.getName());
        Father.introduce();

//        if(1==1){
//            throw new AbortException();
//        }

        Son son = new Son();
//        System.out.println("调用的属性：" + sample.name);
//        System.out.println("调用的属性:" + son.name);
        String msg = "调用的属性:" + son.getName();
        System.out.println(msg);
        Son.introduce();

    }

}
