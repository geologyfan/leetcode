package sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {5, 3, 4, 9, 2, 4, 45, -2, 6};
        new InsertionSort().insertSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void insertSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > temp) j--;
            System.arraycopy(nums,j+1,nums,j+2,(i-1)-(j+1)+1);
            nums[j + 1] = temp;
        }

    }

//    public void insert(int[] nums,int )
}
