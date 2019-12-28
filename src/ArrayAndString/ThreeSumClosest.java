package ArrayAndString;

import sort.QuickSort;

import static java.lang.System.out;

public class ThreeSumClosest {
    public static void main(String[] args){
        int nums[] = {6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,-9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10};
        out.println(new ThreeSumClosest().threeSumClosest(nums,-52));
    }

    public int threeSumClosest(int[] nums,int target){
        if(nums.length<3) return 0;
        new QuickSort().quickSort(nums,0,nums.length-1);
        int closest = nums[0]+nums[1]+nums[2];
        int length = nums.length;
        for(int i=0;i<length-2;i++){
            int low = i+1,high = length-1;
            while (low<high){
                int temp = nums[i]+nums[low]+nums[high];
                if(Math.abs(temp-target)<Math.abs(closest-target)){
                    closest = temp;
                }
                if(temp<target) low++;
                else if(temp>target) high--;
                else return target;
            }
        }
        return closest;
    }
}
