package job.seek.javasort;

import org.junit.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 希尔排序
 * a、基本上和插入排序一样的道理
 * <p>
 * 　　b、不一样的地方在于，每次循环的步长，通过减半的方式来实现
 * <p>
 * 　　c、说明：基本原理和插入排序类似，不一样的地方在于。
 * 通过间隔多个数据来进行插入排序。
 *
 * @author Yiuanhm
 */
public class Sort04 {

    public static void main(String[] args) {
        int arr[] = {6, 5, 3, 2, 4, 14};
        //6s
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 9999; i++) {
//            list.add((int)(Math.random()*9999)+1);
//        }
//        Integer[] arr = list.toArray(new Integer[]{});
        Instant fromDate = Instant.now();
        //调整循环的步长，通过减半的方式来实现，
        //相当于将数组元素分区后进行处理
        for (int i = arr.length / 2; i > 0; i /= 2) {
            //j,k为插入排序，不过步长为i
            //i层循环控制步长
            //循环处理区间中的元素值，相当于冒泡排序的外层循环
            for (int j = i; j < arr.length; j++) {
                //j控制无序端的起始位置
                //相当于冒泡排序的内层循环
                //这里i代表当前分区数组的默认起点
                for (int k = j; k > 0 && k - i >= 0; k -= i) {
                    if (arr[k] < arr[k - 1]) {
                        int temp = arr[k - 1];
                        arr[k - 1] = arr[k];
                        arr[k] = temp;
                    } else {
                        //如果不小于，说明插入完毕，退出内层循环
                        break;
                    }
                }
            }
        }
        Instant toDate = Instant.now();
        long seconds = ChronoUnit.SECONDS.between(fromDate, toDate);
        long minutes = ChronoUnit.MINUTES.between(fromDate, toDate);
        System.out.println("耗费时间seconds：" + seconds);
        System.out.println("耗费时间minutes：" + minutes);
        System.out.println(Arrays.toString(arr));
//        StringJoiner joiner = new StringJoiner(",");
//        Arrays.stream(arr).mapToObj(String::valueOf).forEach(joiner::add);
//        System.out.println(joiner.toString());

        List list = new ArrayList<>();

    }

    @Test
    public void sort() {
        int arr[] = {6, 5, 3, 2, 4, 14};
        //数组分区
        for (int i = arr.length / 2; i > 0; i /= 2) {
            //仿冒泡排序机制
            for (int j = i; j < arr.length; j++) {
                //这里i代表当前分区数组的起始位置
                //k - i >= 0 为了保证不越界
                for (int k = j; k > 0 && k - i >= 0; k -= i) {
                    if (arr[k] < arr[k - 1]) {
                        int temp = arr[k - 1];
                        arr[k - 1] = arr[k];
                        arr[k] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void sort02() {
        System.out.println(1/2);
    }

}