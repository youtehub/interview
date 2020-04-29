package job.seek.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Java8 {
    public static void main(String[] args) {
        Runnable rum = () -> System.out.println("1. Lambda 表达式");
        rum.run();

        BinaryOperator<Long> cal = (x, y) -> {
            System.out.println("函数是接口方法");
            return x + y;
        };
        System.out.println(cal.apply(33L,2L));

        List<String> list = new ArrayList<String>();
    }
}
