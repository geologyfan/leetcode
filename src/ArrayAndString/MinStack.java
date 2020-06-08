package ArrayAndString;

import java.util.*;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/21
 */

public class MinStack {


    public static void main(String[] args){
        int[] arr = new int[]{3,1,1};
        System.out.println(minArray(arr));
    }

    public static int minArray(int[] numbers) {
        if(numbers[0]<numbers[numbers.length-1])
            return numbers[0];
        int low =0,high = numbers.length-1;
        while(low<high){
            int mid = (low+high)/2;
            if(numbers[mid]<numbers[low]){
                high=mid;
            }else if(numbers[mid]>numbers[high]){
                low = mid+1;
            }else{
                high--;
            }
        }
        return numbers[low];
    }

}
