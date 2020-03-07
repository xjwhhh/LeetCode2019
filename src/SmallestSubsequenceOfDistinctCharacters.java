import java.util.Stack;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-07 13:46
 * @Email xjwhhh233@outlook.com
 */
public class SmallestSubsequenceOfDistinctCharacters {
    public String smallestSubsequence(String text) {
        int len = text.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            Character c = text.charAt(i);
            if (stack.contains(c)) {
                continue;
            }
            while (!stack.empty() && c < stack.peek() && text.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();

    }
}
