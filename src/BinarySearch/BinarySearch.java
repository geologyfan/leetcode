package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 2, 2};
        System.out.println(new BinarySearch().binarySearch(nums, 0, nums.length - 1, 2));
    }

    public int binarySearch(int[] nums, int low, int high, int target) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
}
