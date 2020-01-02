package sort;

public class SelectionSort {
    public static void main(String[] args){
        int[] nums = {5, 3, 4, 9, 2, 4, 45, -2, 6};
        new SelectionSort().selectionSort(nums,3,nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public void selectionSort(int[] nums,int low,int high){
        for(int i=low;i<=high;i++){
            int min = i;
            for(int j=i+1;j<=high;j++){
                if(nums[j]<nums[min])
                    min = j;
            }
            int temp = nums[min];
            nums[min]=nums[i];
            nums[i] = temp;
        }
    }
}
