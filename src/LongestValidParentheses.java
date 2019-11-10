import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        char[] chars=s.toCharArray();
        int max=0;
        stack.push(-1);
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='('){
                stack.push(i);
            }
            else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }


        }
        return max;

    }
}
