package com.atguigu.sort.order;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 冒泡排序
 * 　a、冒泡排序，是通过每一次遍历获取最大/最小值
 * <p>
 * 　　b、将最大值/最小值放在尾部/头部
 * <p>
 * 　　c、然后除开最大值/最小值，剩下的数据在进行遍历获取最大/最小值
 *
 * @author Yiuanhm
 */
public class Sort01 {

    public static void main(String[] args) {
//        int arr[] = {8, 5, 3, 2, 4};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9999; i++) {
            list.add((int)(Math.random()*9999)+1);
        }
        Integer[] arr = list.toArray(new Integer[]{});
        Instant fromDate = Instant.now();
        //外层循环，遍历次数
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                //内层循环，升序（如果前一个值比后一个值大，则交换）
                //内层循环一次，获取一个最大值
                if (arr[j] > arr[j +1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
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