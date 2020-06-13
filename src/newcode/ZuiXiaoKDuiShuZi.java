package newcode;

import java.util.*;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/12
 */

public class ZuiXiaoKDuiShuZi {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 3};
        System.out.println(kSmallestPairs(nums1, nums2, 2));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> (nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]));
        List<List<Integer>> res = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 || len2 == 0 || k == 0) {
            return res;
        }
        for (int i = 0; i < len1; i++) {
            priorityQueue.offer(new int[]{i, 0});
        }
        while (k > 0 && !priorityQueue.isEmpty()) {
            int[] temp = priorityQueue.poll();
            if (temp[1] + 1 < len2) {
                priorityQueue.offer(new int[]{temp[0], temp[1] + 1});
            }
            List<Integer> min = new ArrayList<>(2);
            min.add(nums1[temp[0]]);
            min.add(nums2[temp[1]]);
            res.add(min);
            k--;

        }
        return res;
    }


}
