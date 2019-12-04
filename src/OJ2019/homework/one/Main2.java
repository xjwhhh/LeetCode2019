package OJ2019.homework.one;

import java.util.*;

class Main2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int cas = scanner.nextInt();
        while (cas> 0) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] num = new int[m][n];
            for(int i =0;i<m;i++){
                for(int j=0;j<n;j++){
                    int temp = scanner.nextInt();
                    num[i][j] =temp;
                    //每一层的数字等于这一列向上连续1的个数+1或就是0
                    //将问题转化为很多直方图，最大面积的问题
                    if(i!=0&&temp!=0)
                        num[i][j]=num[i-1][j]+1;
                }
            }
            int max=0;
            for(int i=0;i<m;i++){
                max = Math.max(max,maxArea(num[i]));
            }
            System.out.println(max);
            cas--;
        }
    }
    public static int maxArea(int[] height){
        if (height.length==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i=1, max = height[0];
        stack.push(0);

        while(i< height.length||(i==height.length&& !stack.isEmpty()) ){
            if(i!=height.length && (stack.isEmpty() ||height[i] >= height[stack.peek()])){
                stack.push(i);
                i++;
            }
            else {
                int top  = height[stack.pop()];
                int currMax = !stack.isEmpty()? top *(i - stack.peek()-1): top *i;
                max = Math.max(currMax, max);
            }
        }

        return max;
    }
}
