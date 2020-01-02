package HashTable;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Hashtable;

public class ValidSudo {
    public static void main(String[] args) {
//        new ValidSudo().isValidSudoku();
    }
    //TODO
    public boolean isValidSudoku(char[][] board) {
        Hashtable<Character, Integer> hashtable = new Hashtable<>();
        hashtable.put('1', 1);
        hashtable.put('2', 1);
        hashtable.put('3', 1);
        hashtable.put('4', 1);
        hashtable.put('5', 1);
        hashtable.put('6', 1);
        hashtable.put('7', 1);
        hashtable.put('8', 1);
        hashtable.put('9', 1);
        for (int i = 0; i < 9; i++) {
            if (!isValid(hashtable, board, i, i, 0, 8))
                return false;
            if (!isValid(hashtable, board, 0, 8, i, i))
                return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isValid(hashtable, board, i * 3, i * 3 + 2, j * 3, j * 3 + 2))
                    return false;
            }
        }
        return true;
    }

    public boolean isValid(Hashtable<Character, Integer> hashtable, char[][] board, int highStart, int highEnd, int widthStart, int widthEnd) {
        hashtable.replaceAll((c, v) -> 1);
        char temp;
        for (int i = highStart; i <= highEnd; i++) {
            for (int j = widthStart; j <= widthEnd; j++) {
                temp = board[i][j];
                if (hashtable.get(temp) > 0)
                    hashtable.put(temp, 0);
                else
                    return false;
            }
        }
        return true;
    }


}
