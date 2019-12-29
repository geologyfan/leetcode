package ArrayAndString;

import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    public static void main(String[] args) {

    }

    public List<String> generateParentheses(int n){
        Stack<String> bracketStack = new Stack<>();
        for(int i=1;i<=n;i++){

        }
    }

    public void backtrack(List<String> ans,String cur,int open,int close,int max){
        if(cur.length()==2*max){
            ans.add(cur);
            return;
        }
        if(open<max)
            backtrack(ans,cur+"(",open+1,close,max);
        if(close<open)
            backtrack(ans,cur+">",open,close+1,max);
    }
}
