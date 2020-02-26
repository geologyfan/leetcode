package ArrayAndString;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/25
 */

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 9};
        new MergeSortedArrays().merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int finPos = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums2[n - 1] < nums1[m - 1]) {
                nums1[finPos--] = nums1[m-- - 1];
            } else {
                nums1[finPos--] = nums2[n-- - 1];
            }
        }
        while (n > 0) {
            nums1[finPos--] = nums2[n-- - 1];
        }
    }
}
