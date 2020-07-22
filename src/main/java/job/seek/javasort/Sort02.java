package job.seek.javasort;

import org.junit.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 选择排序
 * a、将第一个值看成最小值
 * <p>
 * 　　b、然后和后续的比较找出最小值和下标
 * <p>
 * 　　c、交换本次遍历的起始值和最小值
 * <p>
 * 　　d、说明：每次遍历的时候，将前面找出的最小值，看成一个有序的列表，
 * 后面的看成无序的列表，然后每次遍历无序列表找出最小值。
 *
 * @author Yiuanhm
 */
public class Sort02 {

    public static void main(String[] args) {
//        int arr[] = {6, 5, 3, 2, 4};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9999; i++) {
            list.add((int) (Math.random() * 9999) + 1);
        }
        Integer[] arr = list.toArray(new Integer[]{});
        Instant fromDate = Instant.now();
        //选择，记录所有循环的次数
        for (int i = 0; i < arr.length; i++) {
            //默认第一个是最小值
            int min = arr[i];
            //记录最小的下标
            int index = i;
            //通过与后面的数据进行比较得出，最小值和下标
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            //然后将最小值与本次循环的，开始值交换
            int temp = arr[i];
            arr[i] = min;
            arr[index] = temp;
            //说明：将i前面的数据看成一个排好的队列，
            // i后面的看成一个无序队列。每次只需要找无需的最小值，做替换
        }
        Instant toDate = Instant.now();
        long seconds = ChronoUnit.SECONDS.between(fromDate, toDate);
        long minutes = ChronoUnit.MINUTES.between(fromDate, toDate);
        System.out.println("耗费时间seconds：" + seconds);
        System.out.println("耗费时间minutes：" + minutes);
        System.out.println(Arrays.toString(arr));
//        Arrays.stream(arr).forEach(System.out::println);
    }

    @Test
    public void sort02() {
        Integer[] arr = {54, 11, 2, 8, 5, 21};
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[index] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

}