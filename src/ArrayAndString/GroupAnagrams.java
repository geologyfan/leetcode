package ArrayAndString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = new GroupAnagrams().groupAnagrams(strs);
        for (List<String> re : res) {
            System.out.println(re);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> hashMap = new HashMap<>();
        int pos = 0;
        for (String str : strs) {
            String resortStr = stringResort(str);
            if (hashMap.containsKey(resortStr)) {
                int index = hashMap.get(resortStr);
                res.get(index).add(str);
            } else {
                hashMap.put(resortStr, pos++);
                List<String> temp = new ArrayList<>();
                temp.add(str);
                res.add(temp);
            }
        }
        return res;
    }

    public String stringResort(String str) {
        char[] chars = str.toCharArray();
        for (int i = str.length() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (chars[j] - chars[j + 1] > 0) {
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;

                }
            }
        }
        return new String(chars);
    }
}
