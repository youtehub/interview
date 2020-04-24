package com.atguigu.sort.order;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 插入排序
 * a、默认从第二个数据开始比较。
 * <p>
 * 　　b、如果第二个数据比第一个小，则交换。然后在用第三个数据比较，
 * 如果比前面小，则插入（狡猾）。否则，退出循环
 * <p>
 * 　　c、说明：默认将第一数据看成有序列表，后面无序的列表循环每一个数据，
 * 如果比前面的数据小则插入（交换）。否则退出。
 *
 * @author Yiuanhm
 */
public class Sort03 {

    public static void main(String[] args) {
//        int arr[] = {7, 5, 3, 2, 4,3,6,10,123,0};  8S
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9999; i++) {
            list.add((int)(Math.random()*9999)+1);
        }
        Integer[] arr = list.toArray(new Integer[]{});
        Instant fromDate = Instant.now();
        for (int i = 1; i < arr.length; i++) {
            //外层循环，从第二个开始比较
            //通过与后面的数据进行比较得出，最小值和下标
            for (int j = i; j > 0; j--) {
                //内存循环，与前面排好序的数据比较，
                // 如果后面的数据小于前面的则交换
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    //如果不小于，说明插入完毕，退出内层循环
                    break;
                }
            }
        }
        Instant toDate = Instant.now();
        long seconds = ChronoUnit.SECONDS.between(fromDate, toDate);
        long minutes = ChronoUnit.MINUTES.between(fromDate, toDate);
        System.out.println("耗费时间seconds：" + seconds);
        System.out.println("耗费时间minutes：" + minutes);
        System.out.println(Arrays.toString(arr));
//        Arrays.stream(arr).forEach(System.out::println);
    }

}