package reflect;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: bin
 * @create: 2020/4/12
 */

public class t01 {
    public static void main(String[] args) throws IllegalAccessException {
        List<String> obj = Arrays.asList(new String[]{"ab","cd"});
        Class<?> cls = obj.getClass();
        for(Field f: cls.getDeclaredFields()){
            f.setAccessible(true);
            System.out.println(f.getName()+" - " +f.get(obj));
        }
    }

}
