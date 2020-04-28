package job.seek.javasort;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

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
        //调整循环的步长，通过减半的方式来实现
        for (int i = arr.length / 2; i > 0; i /= 2) {
            //j,k为插入排序，不过步长为i
            //i层循环控制步长
            for (int j = i; j < arr.length; j++) {
                //j控制无序端的起始位置
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
    }

}