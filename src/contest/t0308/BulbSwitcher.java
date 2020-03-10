package contest.t0308;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/8
 */

public class BulbSwitcher {
    public static void main(String[] args) {
        System.out.println(new BulbSwitcher().numTimesAllBlue(new int[]{2,1,3,5,4}));
    }

    public int numTimesAllBlue(int[] light) {
        int len = light.length;
        int[] switched = new int[len];
        int count =0;
        int latest = 0;
        for (int i = 0; i < len; i++) {
            latest = Math.max(light[i]-1, latest);
            switched[light[i]-1] = 1;
            if(judge(switched, light[i]-1, latest))
                count++;
        }
        return count;
    }

    public boolean judge(int[] switched, int cur, int latest) {
        if (cur == 0) {
            switched[0] = 2;
            for (int i = 1; i < latest; i++) {
                if (switched[i] == 0)
                    return false;

                switched[i] = 2;

            }
            return true;
        }
        if (switched[cur - 1] == 2) {
            if (cur == latest) {
                switched[cur] = 2;
                return true;
            } else if (cur < latest) {
                for (int i = cur; i < latest; i++) {
                    if (switched[i] == 0)
                        return false;

                    switched[i] = 2;

                }
                return true;
            }
        } else if (switched[cur - 1] == 1) {
            for (int i = cur - 1; i >= 0; i--) {
                if (switched[i] == 0)
                    return false;
            }
            for (int i = 1; i < latest; i++) {
                if (switched[i] == 0)
                    return false;

                switched[i] = 2;

            }
            return true;
        }
        return false;
    }



}
