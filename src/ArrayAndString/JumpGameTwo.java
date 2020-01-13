package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

public class JumpGameTwo {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new JumpGameTwo().jump2(nums));
    }

    //这种方法要n*n的时间复杂度，太慢了
    public int jump(int[] nums) {
        List<Integer> route = new ArrayList<>();
        int last = nums.length - 1;
        while (last > 0) {
            int pre = last;
            for (int i = 0; i < last; i++) {
                if (nums[i] + i >= last) {
                    pre = i;
                    break;
                }
            }
            route.add(pre);
            last = pre;
        }
        return route.size();
    }

    // 这个更慢
    public int jump2(int[] nums) {
        int[] steps = new int[nums.length];
        steps[steps.length - 1] = 0;
        for (int i = steps.length - 2; i >= 0; i--) {
//            if (nums[i] == 0) {
//                steps[i] = Integer.MAX_VALUE;
//                continue;
//            }
            int min = steps[i + 1];
            for (int j =  1; i+j < steps.length && j <= nums[i]; j++) {
                if (steps[i+j] < min)
                    min = steps[i+j];
            }
            steps[i] = min + 1;
        }
        return steps[0];
    }


}
