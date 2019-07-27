import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        HashMap<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            if(map.containsKey(temp)){
                if(stack.isEmpty()){
                    return false;
                }
                else if(stack.pop()!=map.get(temp)){
                    return false;
                }
            }else{
                stack.push(temp);
            }
        }
        return stack.isEmpty();


    }
}
