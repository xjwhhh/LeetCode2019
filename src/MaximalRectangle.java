import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-19 16:32
 * @Email xjwhhh233@outlook.com
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        int[] dp=new int[matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            dp[i]=matrix[0][i]=='1'?1:0;
        }
        max=Math.max(max,findMax(dp));
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    dp[j]+=1;
                }else{
                    dp[j]=0;
                }
            }
            max=Math.max(max,findMax(dp));

        }
        return max;

    }

    private int findMax(int[] dp){
        Stack<Integer> stack=new Stack<>();
//        stack.push(-1);
//        int i=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++) {
            while (!stack.isEmpty()&&dp[i] < dp[stack.peek()]) {
//                while () {
                    int j = stack.pop();
                    int k = stack.isEmpty()?-1:stack.peek();
                    int area = (i - k - 1) * dp[j];
                    max = Math.max(max, area);
//                }
            }
            stack.push(i);

        }
        while(!stack.isEmpty()){
            int j=stack.pop();
            int k = stack.isEmpty()?-1:stack.peek();
            int curArea = (dp.length - k - 1) * dp[j];
            max = Math.max(max, curArea);
        }
        return max;
    }
}
