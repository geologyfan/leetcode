package vivoExam;

import java.util.Scanner;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/7
 */

public class P1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        long res = compute(arr);
        System.out.println(res);
    }
    public static long compute(int[] arr){
        int len = arr.length;
        int last = -1;
        long count = 0;
        for(int i=0;i<len;i++){
            if(arr[i]==0){
                continue;
            }
            count+=(i-1-last)/2;
            last = i;
        }
        count+=(len-last-1)/2;
        return count;
    }

}
