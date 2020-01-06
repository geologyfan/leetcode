package ArrayAndString;

public class SearchInRotatedSortedArray {
//    public static void main(String[] args) {
//        int[] nums = {6, 7, 8, 9, 1, 2, 3, 4};
//        System.out.println(new SearchInRotatedSortedArray().search(nums, 5));
//    }

    public int search(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }

    public static int helper(int[] nums, int low, int high, int target) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] > target) {
            if (nums[mid] >= nums[low] && nums[mid] <= nums[high])
                return helper(nums, low, mid - 1, target);
            else if (nums[mid] >= nums[low] && nums[mid] >= nums[high]) {
                if (nums[low] <= target)
                    return helper(nums, low, mid - 1, target);
                else
                    return helper(nums, mid + 1, high, target);
            } else if (nums[mid] <= nums[low] && nums[mid] <= nums[high]) {
                return helper(nums, low, mid - 1, target);
            } else
                return -1;
        } else {
            if (nums[mid] >= nums[low] && nums[mid] <= nums[high])
                return helper(nums, mid + 1, high, target);
            else if (nums[mid] >= nums[low] && nums[mid] >= nums[high])
                return helper(nums, mid + 1, high, target);
            else if (nums[mid] <= nums[low] && nums[mid] <= nums[high]) {
                if (nums[high] >= target)
                    return helper(nums, mid + 1, high, target);
                else
                    return helper(nums, low, mid - 1, target);
            } else
                return -1;
        }
    }

    public static int helper2(int[] nums, int low, int high, int target) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] > target) {
            if (nums[mid] >= nums[low] && nums[mid] >= nums[high] && nums[low] > target) {
                return helper2(nums, mid + 1, high, target);
            } else
                return helper2(nums, low, mid - 1, target);

        } else {
            if (nums[mid] <= nums[low] && nums[mid] <= nums[high] && nums[high] < target)
                return helper2(nums, low, mid - 1, target);


            else
                return helper2(nums, mid + 1, high, target);

        }
    }
}
