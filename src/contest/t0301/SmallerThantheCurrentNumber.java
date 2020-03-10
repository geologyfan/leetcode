package contest.t0301;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/1
 */

public class SmallerThantheCurrentNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,6,7,0,0,9};
        System.out.println(Arrays.toString(new SmallerThantheCurrentNumber().smallerNumbersThanCurrent(nums)));
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums.length == 0)
            return new int[0];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] sortedArray = arrayCopy(nums);
        int[] count = new int[nums.length];
        Arrays.sort(sortedArray);
        int temp1 = sortedArray[0] - 1;
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] != temp1) {
                hashMap.put(sortedArray[i], i);
                temp1 = sortedArray[i];
            }
        }
        for (int i = 0; i < count.length; i++) {
            count[i] = hashMap.get(nums[i]);
        }
        return count;
    }

    public int[] arrayCopy(int[] nums) {
        int[] newArray = new int[nums.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = nums[i];
        }
        return newArray;
    }

}
