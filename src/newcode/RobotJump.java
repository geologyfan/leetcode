package newcode;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/7
 */

public class RobotJump {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 4};

    }

    private static int compute(int[] heights) {
        double e = 0;
        for (int height : heights) {
            e = Math.ceil((e + height) / 2);
        }
        return (int) e;
    }

}
