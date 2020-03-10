package JVM;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/27
 */

public class TryCatchTest {
    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        int n=5;
        int[] like = new int[]{2,1,3,3,5};
        Arrays.sort(like);
//        for(int i=0;i<n;i++){
//            like[i] = scanner.nextInt();
//        }
        int q = 1;
        int l,r,k;
        int count;
        for(int j=0;j<q;j++){
            l = 1;
            r = 2;
            k = 1;
            int indexOfL = binarySearch(like,0,n-1,l);
            while(indexOfL>0&&like[indexOfL-1]==l)
                indexOfL--;
            int indexOfR = binarySearch(like,indexOfL,n-1,r);
            while(indexOfL<n-1&&like[indexOfR+1]==r)
                indexOfR++;
            int indexOfK = binarySearch(like,indexOfL,indexOfR,k);
            if(-1==indexOfK)
                count =0;
            else
            {count=1;
                int pre = indexOfK-1,post = indexOfK+1;
                while(pre>=0&&like[pre--]==k) count++;
                while(post<n&&like[post++]==k) count++;}
            System.out.println(count);
        }
    }
    public static int binarySearch(int[] nums,int low,int high,int target){
        int mid;
        while(low<=high){
            mid = (low+high)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                high = mid-1;
            else
                low = mid +1;
        }
        return -1;
    }

}
