package ArrayAndString;

import java.util.ArrayList;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/5
 */

public class MergeIntevals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{11, 19}, {1, 3}, {4, 9}, {2, 4}, {3, 10}, {7, 9}};
        MergeIntevals mergeIntevals = new MergeIntevals();
        mergeIntevals.sort(intervals);
        intervals = mergeIntevals.merge(intervals);
        for (int[] interval : intervals) {
            System.out.println(interval[0] + "," + interval[1]);
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 1)
            return new int[0][];
        sort(intervals);
        ArrayList<int[]> output = new ArrayList<int[]>();
        output.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= output.get(output.size() - 1)[1]) {
                output.get(output.size() - 1)[1] = Math.max(intervals[i][1], output.get(output.size() - 1)[1]);
            } else {
                output.add(intervals[i]);
            }
        }
        int[][] res = new int[output.size()][2];
        for(int i=0;i<output.size();i++){
            res[i] = output.get(i);
        }
        return res;
    }

    public void sort(int[][] intervals) {
        sortHelper(intervals, 0, intervals.length - 1);
    }

    public void sortHelper(int[][] intervals, int low, int high) {
        if (low >= high)
            return;
        int start = low, end = high;
        while (start < end) {
            while (start < end && intervals[start][0] < intervals[end][0]) {
                end--;
            }
            if (start < end) {
                swap(intervals, start, end);
                start++;
            }
            while (start < end && intervals[end][0] > intervals[start][0]) {
                start++;
            }
            if (start < end) {
                swap(intervals, start, end);
                end--;
            }
        }
        sortHelper(intervals, low, start - 1);
        sortHelper(intervals, start + 1, high);
    }

    public void swap(int[][] intervals, int pre, int post) {
        int temp = intervals[pre][0];
        intervals[pre][0] = intervals[post][0];
        intervals[post][0] = temp;
        temp = intervals[pre][1];
        intervals[pre][1] = intervals[post][1];
        intervals[post][1] = temp;
    }


}
