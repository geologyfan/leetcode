package Array;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/27
 */

public class UnlockScreen {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    public int lastRemaining(int n, int m) {
        if(m==1||n==0){
            return n;
        }
        Node head = buildCircle(n);
        int i=1;
        while(head.next!=head){
            if((i+1)%m==0){
                head.next = head.next.next;
                i++;
            }
            head = head.next;
            i++;
        }
        return head.val;
    }

    public Node buildCircle(int n){
        Node head = new Node(0);
        Node p = head;

        for(int i=1;i<=n;i++){
            Node q = new Node(i);
            p.next = q;
            p = q;
        }
        p.next = head;
        return head;
    }

    public static void main(String[] args){
        String s = "b_n = a_n+a_(n-1)";
        String[] ss = s.split("=");
        Pattern pattern = Pattern.compile("([a-z]_(?:[a-z0-9]+|\\([a-z0-9+-]+\\)))");
        List<String> rightList = new ArrayList<>();
        Matcher matcher = pattern.matcher(ss[1]);

        while(matcher.find()){
            rightList.add(matcher.group());
        }
        System.out.println(rightList);
        Deque<Integer> maxQue = new LinkedList<>();
        maxQue.getLast();
        int[] arr = new int[]{2,45,1,89};
//        Arrays.sort(arr,(num1,num2)->compare(num1,num2));

    }
    public static int compare(int num1,int num2){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while(num1!=0){
            list1.add(num1%10);
            num1 /=10;
        }
        while(num2!=0){
            list2.add(num2%10);
            num2 /= 10;
        }
        int len1 = list1.size()-1;
        int len2 = list2.size()-1;
        while(len1>=0&&len2>=0){
            if(list1.get(len1)>list2.get(len2)){
                return -1;
            }else if(list1.get(len1)<list2.get(len2)){
                return 1;
            }
            len1--;
            len2--;
        }
        if(len1>0){
            return 1;
        }else if(len2>0){
            return -1;
        }
        return 0;
    }
}
