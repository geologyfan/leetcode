package ArrayAndString;

public class JumpGame {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        int maxStep = 0;
        int cur = 0;
        while (cur < nums.length - 1) {
            maxStep = Math.max(maxStep-1, nums[cur]);
            if (maxStep == 0)
                return false;
            cur++;
        }
        return true;
    }
}
