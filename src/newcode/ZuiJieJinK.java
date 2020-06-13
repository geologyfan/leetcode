package newcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/11
 */

public class ZuiJieJinK {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3};
        System.out.println(findClosestElements(arr, 1, 2));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = Arrays.binarySearch(arr, x);
        int len = arr.length;
        int low, high;
        if (index >= 0) {
            low = high = index;
        } else {
            index = -index - 1;
            if (index == 0) {
                low = high = index;
            } else if (index == arr.length) {
                low = high = arr.length - 1;
            } else {

                if (Math.abs(arr[index] - x) < Math.abs(arr[index - 1] - x)) {
                    low = high = index;
                } else {
                    low = high = index - 1;
                }
            }
        }
        while (high - low + 1 < k) {
            if (high == len - 1) {
                low--;
            } else if (low == 0) {
                high++;
            } else if (Math.abs(arr[high + 1] - x) < Math.abs(arr[low - 1] - x)) {
                high++;
            } else {
                low--;
            }
        }
        List<Integer> list = new ArrayList<>(high - low + 1);
        for (int i = low; i <= high; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
