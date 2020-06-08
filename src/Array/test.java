package Array;

import Tree.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/15
 */

public class test {
    static int[] arr;
    static int max;
    static int min;
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
        int T = 1;
        for(int i=0;i<T;i++){
            int N = 3;
            func(N);
            System.out.println(min+" "+max);
        }
    }
    private static void func(int N){
        arr = new int[N];
        max = 0;
        min = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            arr[i] = i+1;
        }
        dfs(0);
    }
    private static void dfs(int index){
        if(index==arr.length-1){
            int cur = compute();
            max = Math.max(max,cur);
            min = Math.min(min,cur);
            return;
        }
        for(int i=index;i<arr.length;i++){
            swap(index,i);
            dfs(index+1);
            swap(index,i);
        }
    }
    private static int compute(){
        int res =  0;
        for(int num:arr){
            res = Math.abs(res-num);
        }
        return res;
    }
    private static void swap(int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int compute1(int N){
        if(N<2){
            return N;
        }
        int mid = N/2;
        return 1+compute1(N-mid);
    }
    private static boolean compare(String[] version1,String[] version2){

        int i=0;
        while(i<version1.length&&i<version2.length){
            int v1 = Integer.parseInt(version1[i]);
            int v2 = Integer.parseInt(version2[i]);
            if(v1<v2){
                return true;
            }else if(v1>v2){
                return false;
            }
            i++;
        }
        if(i<version1.length){
            return false;
        }
        while(i<version2.length){
            int v2 = Integer.parseInt(version2[i]);
            if(v2>0){
                return true;
            }
            i++;
        }
        return false;
    }

    private static boolean compute(int n){
        Set<Integer> set = new HashSet<>();
        while(true){

            if(n==1){
                return true;
            }
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            int next = 0;
            while(n>0){
                int temp = n%10;
                next+=temp*temp;
                n/=10;
            }
            n = next;
        }
    }


    private static  void func(String str){
        LinkedList<Character> dQueue = new LinkedList<>();
        int index = 0;
        int len = str.length();
        int numOfBracket = 0;
        while(index<len){
            char c = str.charAt(index);
            index++;
            if(c=='('){
                numOfBracket++;
            }else if(c==')'){
                numOfBracket--;
            }
            else if(c=='<'){
                dQueue.removeLast();
            }else{
                if(numOfBracket==0){
                    dQueue.addLast(c);
                }
            }
        }
        for(Character c:dQueue){
            System.out.print(c);
        }
    }

    private static int compute(int[] arr, int m) {
        int res = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                res += (arr[i] & arr[j]) > m ? 1 : 0;
            }
        }
        return res;
    }

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int temp = arr[start];
        while (i < j) {
            while (i < j && arr[j] > temp) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }
            while (i < j && arr[i] <= temp) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = temp;
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);

    }


    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            int doubleLeft = 2 * leftSum;
            if (doubleLeft == sum + nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }

        }
        return false;
    }


    public int missingNumber(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int num : nums) {
            count += num;
        }
        return (len * (len - 1) / 2) - count;
    }

    public int findDuplicate(int[] nums) {
        for (int num : nums) {
            if (nums[num] < 0) {
                return num;
            }
            nums[num] = -nums[num];
        }
        return 0;
    }

    int index = 0;
    int[] res;

    public int[] spiralOrder(int[][] matrix) {
        int l1 = matrix.length;
        if (l1 == 0) {
            return new int[0];
        }
        int l2 = matrix[0].length;

        res = new int[l1 * l2];
        spiral(matrix, 0, l1 - 1, 0, l2 - 1);
        return res;
    }

    private void spiral(int[][] matrix, int start1, int end1, int start2, int end2) {
        if (start1 > end1 || start2 > end2) {
            return;
        }
        for (int i = start2; i <= end2; i++) {
            res[index++] = matrix[start1][i];
        }
        if (start1 == end1) {
            return;
        }
        for (int i = start1 + 1; i <= end1; i++) {
            res[index++] = matrix[i][end2];
        }
        if (start2 == end2) {
            return;
        }

        for (int i = end2 - 1; i >= start2; i--) {
            res[index++] = matrix[end1][i];
        }
        for (int i = end1 - 1; i > start1; i--) {
            res[index++] = matrix[i][start2];
        }
        spiral(matrix, start1 + 1, end1 - 1, start2 + 1, end2 - 1);

    }

    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (set.add(num)) return false;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return (max - min) < 5;
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int max = 0;
        while (right < len) {
            while (right < len && set.add(s.charAt(right))) {
                right++;
            }
            max = Math.max(max, right - left);
            if (right < len) {
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            right++;
        }
        return max;

    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int x = dfs(nums1, 0, nums2, 0, (len1 + len2 + 1) / 2);
        int y = dfs(nums1, 0, nums2, 0, (len1 + len2 + 2) / 2);
        return (x + y) / 2.0;
    }

    int dfs(int[] nums1, int index1, int[] nums2, int index2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 - index1 > len2 - index2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            len1 = len1 + len2;
            len2 = len1 - len2;
            len1 = len1 - len2;
            index1 = index1 + index2;
            index2 = index1 - index2;
            index1 = index1 - index2;
        }
        if (index1 >= len1) {
            return nums2[index2 + k];
        }
        if (k == 0) {
            return Math.min(nums1[index1], nums2[index2]);
        }
        int temp = k / 2;
        int p = Math.min(len2 - 1, index1 + temp - 1);
        int q = index2 + temp;
        if (nums1[p] > nums2[q]) {
            return dfs(nums1, index1, nums2, index2 + temp, k - temp);
        } else {
            return dfs(nums1, p + 1, nums2, index2, k - (p - index1 + 1));
        }
    }


    public int[] maxSlidingWindow1(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int len = nums.length;
        int[] res = new int[len - k + 1];
        for (int i = 0; i < k - 1; i++) {
            add(nums[i], list);
        }
        for (int i = k - 1, j = 0; i < len; i++, j++) {
            add(nums[i], list);
            res[j] = list.getFirst();
            if (nums[j] == res[j]) {
                list.removeFirst();
            }
        }

        return res;
    }

    private void add(int num, LinkedList<Integer> list) {
        while (!list.isEmpty() && list.getLast() < num) {
            list.removeLast();
        }
        list.addLast(num);
    }


    public String minWindow(String s, String t) {
        Map<Character, Integer> mapOfChar = new HashMap<>();
        buildCharMap(t, mapOfChar);
        int leftChar = t.length();
        int lenOfS = s.length();
        int maxLeft = -1, maxRight = lenOfS + 1;

        int p = 0, q = 0;
        while (q < lenOfS) {
            while (q < lenOfS && !judge(mapOfChar)) {
                char tempChar = s.charAt(q);
                Integer num = mapOfChar.get(tempChar);
                if (num != null) {
                    mapOfChar.put(tempChar, num - 1);
                }
                q++;
            }
            if (judge(mapOfChar)) {
                while (judge(mapOfChar)) {
                    char tempChar = s.charAt(p);
                    Integer num = mapOfChar.get(tempChar);
                    if (num != null) {
                        mapOfChar.put(tempChar, num + 1);
                    }
                    p++;
                }
                if ((q - p + 1) < (maxRight - maxLeft)) {
                    maxRight = q;
                    maxLeft = p - 1;
                }
            }


        }

        return maxLeft == -1 ? "" : s.substring(maxLeft, maxRight);
    }

    boolean judge(Map<Character, Integer> mapOfChar) {
        for (Map.Entry<Character, Integer> entry : mapOfChar.entrySet()) {
            if (entry.getValue() > 0) {
                return false;
            }
        }
        return true;
    }

    void buildCharMap(String text, Map<Character, Integer> mapOfChar) {
        for (int i = 0; i < text.length(); i++) {
            char temp = text.charAt(i);
            Integer num = mapOfChar.get(temp);
            if (num == null) {
                mapOfChar.put(temp, 1);
            } else {
                mapOfChar.put(temp, num + 1);
            }
        }
    }


    public Object[] maxSlidingWindow(int[] nums, int k) {

        int high = 0;
        Deque<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>(nums.length - k + 1);
        while (high < k - 1) {
            pushE(queue, nums[high]);
            high++;
        }
        while (high <= nums.length) {
            pushE(queue, nums[high]);
            res.add(queue.getFirst());
            high++;
        }
        return res.toArray();
    }

    public void pushE(Deque<Integer> queue, int k) {
        while (!queue.isEmpty() && queue.getLast() < k) {
            queue.removeLast();
        }
        queue.addLast(k);
    }


    public int[][] findContinuousSequence(int target) {
        int mid = target >> 1;
        int low = 1, high = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        while (low <= mid) {
            if (sum < target) {
                sum += high;
                high++;
            } else if (sum > target) {
                sum -= low;
                low++;
            } else {
                int[] temp = new int[high - low];
                int i = 0;
                for (int j = low; j < high; j++) {
                    temp[i++] = low;
                }
                res.add(temp);
                sum -= low;
                low++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }


    public int search(int[] nums, int target) {
        int leftIndex, rightIndex;
        leftIndex = getLeftK(nums, target, 0, nums.length - 1);
        if (leftIndex == -1) {
            return 0;
        }
        rightIndex = getRightK(nums, target, 0, nums.length - 1);
        return rightIndex - leftIndex + 1;
    }

    public int getLeftK(int[] nums, int target, int low, int high) {
        if (low > high)
            return -1;
        int mid = (low + high) >> 1;
        if (nums[mid] > target) {
            return getLeftK(nums, target, low, mid - 1);
        }
        if (nums[mid] < target) {
            return getLeftK(nums, target, mid + 1, high);
        }
        if (nums[mid] == target) {
            if (mid > 0 && nums[mid - 1] == target) {
                return getLeftK(nums, target, low, mid - 1);
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int getRightK(int[] nums, int target, int low, int high) {
        if (low > high)
            return -1;
        int mid = (low + high) >> 1;
        if (nums[mid] > target) {
            return getLeftK(nums, target, low, mid - 1);
        }
        if (nums[mid] < target) {
            return getLeftK(nums, target, mid + 1, high);
        }
        if (nums[mid] == target) {
            if (mid < (nums.length - 1) && nums[mid + 1] == target) {
                return getLeftK(nums, target, mid + 1, high);
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static int[] singleNumbers(int[] nums) {
        int res1 = 0, res2 = 0, mid = 0;
        for (int num : nums) {
            mid ^= num;
        }
        for (int num : nums) {
            if ((num ^ mid) == 0) {
                res1 ^= num;
            } else {
                res2 ^= num;
            }
        }
        return new int[]{res1};
    }


    public int findAndCount(TreeNode root, int low, int high) {
        while (root != null && (root.val < low || root.val > high)) {
            if (root != null && root.val < low) {
                root = root.right;
            }
            if (root != null && root.val > high) {
                root = root.left;
            }
        }
        return count(root, low, high);
    }


    public int count(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        if (root.val < low) {
            return count(root.right, low, high);
        } else if (root.val > high) {
            return count(root.left, low, high);
        } else {
            return 1 + count(root.left, low, high) + count(root.right, low, high);
        }
    }


}
