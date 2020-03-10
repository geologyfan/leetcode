package multiThread;

import javafx.scene.paint.RadialGradient;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/5
 */

public class HashMapDeadLock {
    public static void main(String[] args) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread() {
                Random rnd = new Random();

                @Override
                public void run() {
                    map.put(rnd.nextInt(), 1);
                }
            };
            t.start();
        }
    }

}
