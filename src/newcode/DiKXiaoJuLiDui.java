package newcode;

import HashTable.PriorityQueueTest;

import java.util.*;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/11
 */

public class DiKXiaoJuLiDui {

    public static void main(String[] args) {
        int[] arr = new int[]{9, 10, 7, 10, 6, 1, 5, 4, 9, 8};
        System.out.println(smallestDistancePair(arr, 18));
    }

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);


        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        while (left < right) {
            int mid = (left + right) >>> 1;
            int count = compute(nums, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static int compute(int[] nums, int mid) {
        int low = 0;
        int high = 0;
        int count = 0;
        while (high < nums.length) {
            while (nums[high] - nums[low] > mid) low++;
            count += high - low ;
            high++;
        }
        return count;
    }


    private static int find(int[] nums, int dis) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int index = Arrays.binarySearch(nums, temp + dis);
            if (index > i) {
                for (int j = index; j > i; j--) {
                    if (nums[j] == temp + dis) {
                        count++;
                    }
                }
                for (int j = index + 1; j < nums.length; j++) {
                    if (nums[j] == temp + dis) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
//private static int find(int[] nums, int dis) {
//
//    int count = 0;
//    int low = 0, high = 0;
//    while (high < nums.length) {
//        if (nums[high] - nums[low] < dis) {
//            high++;
//        } else if (nums[high] - nums[low] > dis) {
//            low++;
//        } else {
//            count++;
//            if (low + 1 < high && nums[low + 1] == nums[low]) {
//                low++;
//            } else {
//                high++;
//            }
//        }
//    }
//    return count;
//}

}
