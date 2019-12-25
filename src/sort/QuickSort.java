package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5, 3, 4, 9, 2, 4, 45, -2, 6};
        new QuickSort().quickSort(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.println(num);
        }
    }

//    public int[] quickSort1(int[] nums) {
//        helper(nums, 0, nums.length - 1);
//        return nums;
//    }

//    public void helper(int[] nums, int start, int end) {
//        if(start>=end)
//            return;
//        int high = end,low = start;
//        int key = nums[start];
//        while(start<end){
//            while(nums[end]>=key&&start<end){
//                end--;
//            }
//            if(start<end){
//                nums[start++]=nums[end];
//                nums[end] = key;
//            }
//            while(nums[start]<=key&&start<end){
//                start++;
//            }
//            if(start<end){
//                nums[end--] = nums[start];
//                nums[start] = key;
//            }
//        }
//        helper(nums,low,start-1);
//        helper(nums,start+1,high);
//
//    }

    public void quickSort(int[] nums, int low, int high) {
        if (low >= high)
            return;
        int start = low, end = high;
        int temp = nums[start];
        while (start < end) {
            while (nums[end] > nums[start] && start < end) end--;
            if (start < end) {
                nums[start++] = nums[end];
                nums[end] = temp;
            }
            while (nums[start] < nums[end] && start < end) start++;
            if (start < end) {
                nums[end--] = nums[start];
                nums[start] = temp;
            }
        }

        quickSort(nums, low, start - 1);
        quickSort(nums, start + 1, high);
    }

}