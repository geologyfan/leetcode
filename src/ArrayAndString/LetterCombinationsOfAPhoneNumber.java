package ArrayAndString;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static javax.swing.UIManager.get;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        List<String> test = new LetterCombinationsOfAPhoneNumber().letterCombinations("23");
        for (String s : test) {
            System.out.println(s);
        }
    }

    public List<String> letterCombinations(String digits) {
        char[] two = {'a', 'b', 'c'};
        char[] three = {'d', 'e', 'f'};
        char[] four = {'g', 'h', 'i'};
        char[] five = {'j', 'k', 'l'};
        char[] six = {'m', 'n', 'o'};
        char[] seven = {'p', 'q', 'r', 's'};
        char[] eight = {'t', 'u', 'v'};
        char[] nine = {'w', 'x', 'y', 'z'};

        List<StringBuffer> linkedList = new LinkedList<>();
        for (int i = 0; i < digits.length(); i++) {
            switch (digits.charAt(i)) {
                case '2':
                    helper(linkedList, two);
                    break;
                case '3':
                    helper(linkedList, three);
                    break;
                case '4':
                    helper(linkedList, four);
                    break;
                case '5':
                    helper(linkedList, five);
                    break;
                case '6':
                    helper(linkedList, six);
                    break;
                case '7':
                    helper(linkedList, seven);
                    break;
                case '8':
                    helper(linkedList, eight);
                    break;
                case '9':
                    helper(linkedList, nine);
                    break;
            }
        }
        List<String> output = new ArrayList<>(linkedList.size());
        for (StringBuffer stringBuffer : linkedList) {
            output.add(stringBuffer.toString());
        }
        return output;
    }

    public void helper(List<StringBuffer> list, char[] num) {
        int preLength = list.size();
        if (0 == preLength) {
            for (char c : num) {
                list.add(new StringBuffer().append(c));
            }
        } else {
            char temp;
            for (int i = 1; i < num.length; i++) {
                temp = num[i];
                for (int j = 0; j < preLength; j++) {
                    StringBuffer newStringBuffer = new StringBuffer(list.get(j));
                    list.add(newStringBuffer.append(temp));
                }
            }
            temp = num[0];
            for (int i = 0; i < preLength; i++) {
                list.get(i).append(temp);
            }
        }
    }
}
