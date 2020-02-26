package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/26
 */

public class SubSets {
    public static void main(String[] args) {
        System.out.println(new SubSets().subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        output.add(new ArrayList<>());

        for (int num:nums) {
            int curSize = output.size();
            for (int i = 0; i < curSize; i++) {
                ArrayList<Integer> temp = new ArrayList<>(output.get(i));
                temp.add(num);
                output.add(temp);
            }
        }
        return output;
    }


}
