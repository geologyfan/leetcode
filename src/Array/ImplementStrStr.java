package Array;

import java.util.*;

public class ImplementStrStr {
    public static void main(String[] args){
//        System.out.println(sumFourDivisors(new int[]{7286,18704,70773,8224,91675}));
        List<Integer> list = new ArrayList<>();
//        int[] arr = list.toArray(new int[list.size()]);
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (Integer integer : pQueue) {

        }


    }

    public static int sumFourDivisors(int[] nums) {
        int sum = 0;
        Deque<Integer> queue = new LinkedList<>();

        for(int num : nums){
            sum+=judge(num);
        }
        return sum;
    }

    public static int  judge(int num){
        int sum = 0;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        switch (sum){
            case 1:
                System.out.println(1);
                System.out.println(1);
            case 2:
                System.out.println(2);
        }
        Collections.emptySet();
        for(int i=1;i<=Math.sqrt(num);i++){
            if(num%i==0){
                int temp = num/i;
                if(temp==i){
                    count+=1;
                    sum+=i;
                }else{
                    count+=2;
                    sum=sum+i+temp;
                }
            }

        }
        if(count>3){
            return sum;
        }
        return 0;

    }


}
