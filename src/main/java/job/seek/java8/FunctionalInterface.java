package job.seek.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 函数式接口
 *
 * @author yiyh
 */
public class FunctionalInterface {
    public static void main(String[] args) {
        BinaryOperator<Integer> money = (x,y) -> x+y;
        System.out.println(money.apply(12,74));
    }
}

