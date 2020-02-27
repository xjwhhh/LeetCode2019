import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import java.util.Arrays;

public class MinimumPathSum {
    public int minPathSum(int[][] matrix) {
        if(matrix==null){
            return 0;
        }
        int row=matrix.length;
        if(row==0){
            return 0;
        }
        int column=matrix[0].length;
        int[][] dp=new int[row][column];
        dp[0][0]=matrix[0][0];
        for(int i=1;i<row;i++){
            dp[i][0]=dp[i-1][0]+matrix[i][0];
        }
        for(int j=1;j<column;j++){
            dp[0][j]=dp[0][j-1]+matrix[0][j];
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<column;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+matrix[i][j];
            }
        }

        return dp[row-1][column-1];
    }

    public int minPathSum1(int[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int[] dp = new int[matrix[0].length];
        for (int i = 0; i <=matrix.length-1; i++) {
            for (int j = 0; j <=matrix[0].length-1; j++) {
                if(i == 0 && j != 0)
                    dp[j] = matrix[i][j] +  dp[j - 1];
                else if(j == 0 && i != 0)
                    dp[j] = matrix[i][j] + dp[j];
                else if(j != 0 && i != 0)
                    dp[j] = matrix[i][j] + Math.min(dp[j], dp[j - 1]);
                else
                    dp[j] = matrix[i][j];
            }
        }
        return dp[matrix[0].length-1];
    }

    public int helper(int[][] matrix, int i, int j) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        }
        if (i == matrix.length || j == matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        return matrix[i][j] + Math.min(helper(matrix, i + 1, j), helper(matrix, i, j + 1));
    }
    public int solve(int[][] matrix) {
        if(matrix.length==0){
            return 0;
        }

        return helper(matrix, 0, 0);
    }

//    public static void main(String[] args){
//        int[][] a=new int[1][3];
//        System.out.println(a.length);
//        System.out.println(a[0].length);
//    }

    public int minPathSum2(int[][] matrix) {
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if(j == matrix[0].length - 1 && i != matrix.length - 1) {
                    matrix[i][j] = matrix[i][j] + matrix[i + 1][j];
                }
                else if(i == matrix.length - 1 && j != matrix[0].length - 1) {
                    matrix[i][j] = matrix[i][j] + matrix[i][j + 1];
                }
                else if(j != matrix[0].length - 1 && i != matrix.length - 1) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i][j + 1]);
                }
            }
        }
        return matrix[0][0];
    }

//    public static void main(String[] args){
//        int[] a=new int[3];
//        System.out.println(a.toString());
//        System.out.println(a.toString().charAt(1));
//    }


        public static String[] solution(String ss){
            String[] sss=new String[ss.length()];
            for(int i = 0; ss.length() > i; i++){
                sss[i]= String.valueOf(ss.charAt(i));
            }
            Arrays.sort(sss);

            System.out.println(Arrays.toString(sss));
            String aa=sss.toString();

            for(int i=0;i<sss.length;i++){
                System.out.print(sss[i]);
            }
            return sss;
        }

        public static void main(String[] args) {
            String ss="bdcae";
//        System.out.println(ss);
            String[] result=solution(ss);
            for(int i=0;i<result.length;i++){
                System.out.print(result[i]);
            }
        }




}
