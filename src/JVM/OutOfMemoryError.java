package JVM;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryError {
    public static void main(String[] args) {
        new OutOfMemoryError().JavaVMStackOF();
    }

    static class OOMObject {
    }

    public void HeapOOM() {
        // VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

    public void JavaVMStackOF() {
        //VM Args : -Xss128k
        int stackLength = 1;

        try {
            stackLength = new OutOfMemoryError().stackLeak(stackLength);
        } catch (Throwable e) {
            System.out.println("stack length:" + stackLength);
            throw e;
        }
    }

    public int stackLeak(int stackLength) {
        stackLength++;
        stackLeak(stackLength);
        return stackLength;
    }
}
