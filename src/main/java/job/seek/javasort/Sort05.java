package job.seek.javasort;

import java.util.ArrayList;
import java.util.List;

/**
 * 快速排序
 * 　a、确认列表第一个数据为中间值，第一个值看成空缺（低指针空缺）。
 * <p>
 * 　　b、然后在剩下的队列中，看成有左右两个指针（高低）。
 * <p>
 * 　　c、开始高指针向左移动，如果遇到小于中间值的数据，则将这个数据赋值到低指针空缺，
 * 并且将高指针的数据看成空缺值（高指针空缺）。然后先向右移动一下低指针，并且切换低指针移动。
 * <p>
 * 　　d、当低指针移动到大于中间值的时候，赋值到高指针空缺的地方。
 * 然后先高指针向左移动，并且切换高指针移动。重复c、d操作。
 * <p>
 * 　　e、直到高指针和低指针相等时退出，并且将中间值赋值给对应指针位置。
 * <p>
 * 　　f、然后将中间值的左右两边看成行的列表，进行快速排序操作。
 *
 * @author Yiuanhm
 */
public class Sort05 {

    public static void main(String[] args) {

        int arr[] = {7, 5, 3, 2, 4, 1, 8, 9, 6};

        //快速排序
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
    }

    /**
     * 对数组指定数组进行快速排序
     *
     * @param arr  排序数组
     * @param low  最小下标
     * @param high 最大下标
     */
    public static void quickSort(int[] arr, int low, int high) {
        //如果指针在同一位置(只有一个数据时)，退出
        if (high - low < 1) {
            return;
        }
        //标记，从高指针开始，还是低指针（默认高指针）
        boolean flag = true;
        //记录指针的其实位置
        int start = low;
        int end = high;
        //默认中间值为低指针的第一个值
        int midValue = arr[low];
        while (true) {
            //高指针移动
            if (flag) {
                //如果列表右方的数据大于中间值，则向左移动
                if (arr[high] > midValue) {
                    high--;
                } else if (arr[high] < midValue) {
                    //如果小于，则覆盖最开始的低指针值，并且移动低指针，标志位改成从低指针开始移动
                    arr[low] = arr[high];
                    low++;
                    flag = false;
                }
            } else {
                //如果低指针数据小于中间值，则低指针向右移动
                if (arr[low] < midValue) {
                    low++;
                } else if (arr[low] > midValue) {
                    //如果低指针的值大于中间值，则覆盖高指针停留时的数据，并向左移动高指针。切换为高指针移动
                    arr[high] = arr[low];
                    high--;
                    flag = true;
                }
            }
            //当两个指针的位置相同时，则找到了中间值的位置，并退出循环
            if (low == high) {
                arr[low] = midValue;
                break;
            }
        }
        //然后出现有，中间值左边的小于中间值。右边的大于中间值。
        //然后在对左右两边的列表在进行快速排序
        quickSort(arr, start, low - 1);
        quickSort(arr, low + 1, end);
    }


}