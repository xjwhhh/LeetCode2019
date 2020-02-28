package sword;

import java.util.Stack;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-28 15:38
 * @Email xjwhhh233@outlook.com
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int index=0;
        for(int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty()&&stack.peek()==popped[index]){
                stack.pop();
                index++;
            }
        }
        for(int i=index;i<popped.length;i++){
            if(stack.peek()==popped[i]){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();

    }
}
