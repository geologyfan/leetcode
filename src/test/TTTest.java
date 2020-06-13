package test;

import org.junit.Test;
import sun.misc.Unsafe;

import java.io.*;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: bin
 * @create: 2020/6/11
 */

public class TTTest implements Serializable {


    @Test
    public void serializableTest() {


        class A {
            int i = 1;
            String name = "default";

            //            B b = new B();
            A() {

            }

            A(int i, String s) {
                this.i = i;
                this.name = s;
            }

        }


        class B extends A implements Serializable {
            //            String s = "1235";

        }


        B b = new B();
        System.out.println(b.name);

        try {

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("I:\\leetcode\\src\\test\\temp"));
            out.writeObject(b);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("I:\\leetcode\\src\\test\\temp"));
            B b1 = (B) in.readObject();
            in.close();
//            System.out.println(list1.get(1).name);
            System.out.println(b1.name);
//            System.out.println(a2 == a);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        Class strClass = String.class;
        Field[] declaredFields = strClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        Unsafe u = Unsafe.getUnsafe();

    }

    @Test
    public void findKthNumber() {
        int m = 3, n = 3, k = 5;
        long left = 1;
        long right = m * n;

        while (left < right) {
            long mid = (right + left) >> 1;

            int count = 0;
            for (int i = 1; i <= m; i++) {
                count += Math.min(n, mid / i);
            }
            if (count < k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }

    @Test
    public void func2() {


        int[] arr = new int[]{1, 2, 4, 5};
        System.out.println(find(arr, 6));
    }


    @Test
    public void fun3() {
        int[][] matrix = new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println(kthSmallest(matrix, 8));
    }


    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int right = matrix[n - 1][n - 1];
        int left = matrix[0][0];
        while (left < right) {
            int mid = (left + right) >> 1;
            int count = 0;
            int x = 0, y = n - 1;
            while (x < n && y >= 0) {
                if (matrix[x][y] <= mid) {
                    count += y + 1;
                    x++;
                } else {
                    y--;
                }
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    int find(int[] arr, int num) {

        int res = Arrays.binarySearch(arr, num);
        return res ;
    }



}
