package Array;

public class MaxArea {
    public static void main(String[] args) {
        int[] height = new int[]{1, 1};
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxArea(height));
    }

    public int maxArea(int[] height) {
        int maxarea = 0;
        int left = 0;
        int right = height.length - 1;

        for (int i = 0; i < height.length && height[i] >= height[left]; i++) {

            for (int j = height.length - 1; j > i && height[j] >= height[right]; j--) {

                int temp = (j - i) * getMin(height[i], height[j]);
                if (temp > maxarea) {
                    maxarea = temp;
                    left = i;
                    right = j;
                }

            }

        }
        return maxarea;
    }

    public int getMin(int x, int y) {
        return x > y ? y : x;
    }

//    public int maxArea_2(int[] height) {
//        int maxarea = 0;
//        int left = 0;
//        int right = height.length;
//        while (left < right) {
//            maxarea = Math.max(maxarea, (right - left) * Math.min(height[left], height[right]));
//            if (height[left] < height[right])
//                left++;
//            else
//                right--;
//        }
//    }
}
