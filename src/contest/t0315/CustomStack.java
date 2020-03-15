package contest.t0315;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/15
 */

public class CustomStack {
    private int[] stack;
    int top;

    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        top = 0;
    }

    public void push(int x) {
        if (top >= stack.length)
            return;
        stack[top++] = x;
    }

    public int pop() {
        if (top == 0)
            return -1;
        return stack[--top];
    }

    public void increment(int k, int val) {
        k = Math.min(k, top);
        for (int i = 0; i < k; i++) {
            stack[i] += val;
        }
    }

}
