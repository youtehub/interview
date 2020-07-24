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
public class Father02 {
    protected String name = "父亲属性";

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
        checkedList.add(12);
        System.out.println(checkedList);
        //输出结果:[123, 0, hello]


    }

}

