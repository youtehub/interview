package job.seek.java8;

import org.junit.Test;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用
 *
 * @author yiyh
 */
public class MethodReferences {
    public static void main(String[] args) {

    }

    @Test
    public void methodReferences() {
        BinaryOperator<Double> min = Math::min;
        Double minValue = min.apply(15.35, 77.6);
        System.out.println(minValue);

        Consumer<Integer> consumer = System.out::println;
        consumer.accept(75);
    }

    @Test
    public void constructorReferences() {
        //构造器引用
        Supplier<Employee> sup1 = () -> new Employee();
        Employee emp = sup1.get();
        System.out.println(emp);

        //构造器引用
        //根据参数列表自动匹配构造器
        Supplier<Employee> sup2 = Employee::new;
        emp = sup2.get();
        System.out.println(emp);
    }

    @Test
    public void arrayReferences() {
        Function<Integer,String[]> fun = x -> new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);

        Function<Integer,String[]> fun1 = String[]::new;
        String[] strs1 = fun1.apply(10);
        System.out.println(strs1.length);
    }
}

class Employee {
}


