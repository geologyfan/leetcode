package ArrayAndString;

public class RemoveElement {
    public static void main(String[] args) {

    }

    public int removeElement(int[] nums, int val) {
        int pre = 0, tale = 0;
        int len = nums.length;
        while (tale < len) {
            if (nums[tale] == val) tale++;
            else {
                nums[pre] = nums[tale];
                pre++;
                tale++;
            }
        }
        return pre;
    }
}
