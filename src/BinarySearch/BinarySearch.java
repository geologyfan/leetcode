package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,6,7,9};
        System.out.println(new BinarySearch().binarySearch(nums,0,nums.length,9));
    }

    public int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (nums[mid] == target)
            return mid;
        else if (mid < target)
            return binarySearch(nums, mid + 1, high, target);
        else
            return binarySearch(nums, low, mid - 1, target);
    }
}
