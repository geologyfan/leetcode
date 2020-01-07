package ArrayAndString;

import BinarySearch.BinarySearch;

public class FindFirstAndLastPositionInSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,2,2};
        for (int num : new FindFirstAndLastPositionInSortedArray().searchRange(nums, 2)) {
            System.out.println(num);
        }
    }

    // TODO: 2020/1/7
    public int[] searchRange(int[] nums, int target) {
        int pos = new BinarySearch().binarySearch(nums, 0, nums.length - 1, target);
        if (pos == -1) {
            int[] output = {-1, -1};
            return output;
        }
        int posStart = pos, posEnd = pos;
        while (posStart >= 0 && nums[posStart] == target) posStart--;
        while (posEnd <= nums.length - 1 && nums[posEnd] == target) posEnd++;
        int[] output = {posStart + 1, posEnd - 1};
        return output;
    }
}
