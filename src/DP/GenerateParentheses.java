package DP;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    public static void main(String[] args) {

    }

//    public List<String> generateParentheses(int n){
//        Stack<String> bracketStack = new Stack<>();
//        for(int i=1;i<=n;i++){
//
//        }
//    }

    public void backtrack(List<String> ans, @NotNull String cur, int open, int close, int max){
        if(cur.length()==2*max){
            ans.add(cur);
            return;
        }
        if(open<max)
            backtrack(ans,cur+"(",open+1,close,max);
        if(close<open)
            backtrack(ans,cur+")",open,close+1,max);
    }

    public List<String> generateParentheses1(int n){
        List<String> bracketList = new ArrayList<>();
        if(n==0){
            bracketList.add("");
        }else {
            for(int c=0;c<n;c++){
                for(String left:generateParentheses1(c)){
                    for(String right:generateParentheses1(n-c-1)){
                        bracketList.add("("+left+")"+right);
                    }
                }
            }
        }
        return bracketList;
    }
}
