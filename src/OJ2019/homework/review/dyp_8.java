package OJ2019.homework.review;

import java.util.Scanner;

public class dyp_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        for (int i = 0; i < total; i++) {
            int row=scanner.nextInt();
            int column=scanner.nextInt();
            int[][] matrix=new int[row][column];
            for(int p=0;p<row;p++){
                for(int q=0;q<column;q++){
                    matrix[p][q]=scanner.nextInt();
                }
            }
            helper(matrix,row,column);
        }
    }

    private static void helper(int[][] matrix,int row,int column){
        int[][] dp=new int[row][column];
        if(matrix[row-1][column-1]>0){
            dp[row-1][column-1]=1;
        }else{
            dp[row-1][column-1]=Math.abs(matrix[row-1][column-1])+1;
        }
//        System.out.println(dp[row-1][column-1]);

        for(int i=column-2;i>=0;i--){
            dp[row-1][i]=Math.max(dp[row-1][i+1]-matrix[row-1][i],1);
//            System.out.println(dp[row-1][i]);
        }
        for(int i=row-2;i>=0;i--){
            dp[i][column-1]=Math.max(dp[i+1][column-1]-matrix[i][column-1],1);
//            System.out.println(dp[i][column-1]);
        }
        for(int i=row-2;i>=0;i--){
            for(int j=row-2;j>=0;j--){
                int temp=Math.min(dp[i+1][j],dp[i][j+1]);
                dp[i][j]=Math.max(temp-matrix[i][j],1);
            }
        }

        System.out.println(dp[0][0]);
    }
}
