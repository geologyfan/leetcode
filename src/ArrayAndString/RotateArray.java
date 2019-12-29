package ArrayAndString;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        new RotateArray().rotate(nums,2);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if(length<1||k<1) return;
        k=k%length;
        reverse(nums,0,length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,length-1);

    }

    public void reverse(int[] nums, int low, int high) {
        while (low < high) {
            nums[low] = nums[low] + nums[high];
            nums[high] = nums[low] - nums[high];
            nums[low] = nums[low] -nums[high];
            low++;
            high--;
        }
    }
}
