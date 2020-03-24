import java.util.Stack;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-24 18:41
 * @Email xjwhhh233@outlook.com
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] T) {
        if(T==null||T.length==0){
            return new int[0];
        }
        Stack<Integer> stack=new Stack<>();
        int[] result=new int[T.length];
        stack.push(Integer.MAX_VALUE);
        int index=0;
        while(!stack.isEmpty()){
            while(stack.peek()!=Integer.MAX_VALUE&&T[index]>T[stack.peek()]){
                int left=stack.pop();
                result[left]=index-left;
            }
            stack.push(index);
            index++;
            if(index>T.length-1){
                break;
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek()!=Integer.MAX_VALUE){
                result[stack.pop()]=0;
            }else{
                break;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] T={73,74,75,71,69,72,76,73};
        dailyTemperatures(T);
    }
}
