package ArrayAndString;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/25
 */

public class SortColors {
    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        if(nums.length==0)
            return;
        int zero_one = swapColors(nums, 0, nums.length - 1, 0);

        swapColors(nums, nums[zero_one] == 0 ? zero_one + 1 : zero_one, nums.length - 1, 1);

    }

    public int swapColors(int[] nums, int low, int high, int color) {
        if (low >= high) {
            return low;
        }

        while (low < high) {
            while (low < high && nums[low] == color) low++;
            while (low < high && nums[high] != color) high--;
            if (low < high) {
                nums[high] = nums[low];
                nums[low] = color;
                high--;
                low++;
            }
        }
        return low;
    }
}
