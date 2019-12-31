package ArrayAndString;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int pre = 1, tale = 1;
        while (tale < len) {
            if (nums[tale] == nums[tale - 1]) {
                tale++;
            } else {
                nums[pre] = nums[tale];
                pre++;
                tale++;
            }
        }
        return pre ;
    }
}
