package spring2020.meituan;

import java.util.Scanner;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-12 20:00
 * @Email xjwhhh233@outlook.com
 */
public class One {

    static int n;
    static int[][] board;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        board=new int[2][n];
        dp=new int[2][n];
        scanner.nextLine();
        for(int i=0;i<2;i++){
            String line=scanner.nextLine();
            char[] chars=line.toCharArray();
            for(int j=0;j<n;j++){
                if(chars[j]=='X'){
                    board[i][j]=1;
                }
            }
        }
        helper();

    }

    private static  void helper(){
        if(board[0][0]==1){
            dp[0][0]=0;
        }else{
            dp[0][0]=1;
        }
        dp[1][0]=0;
//        if(board[1][0]==1){
//            dp[1][0]=0;
//        }

        for(int i=1;i<board[0].length;i++){
            for(int j=0;j<board.length;j++){
                if(board[j][i]==1){
                    dp[j][i]=0;
                }else{
                    if(j==0){
                        dp[j][i]=dp[j][i-1]+dp[j+1][i-1];
                    }else{
                        dp[j][i]=dp[j][i-1]+dp[j-1][i-1];
                    }
                }
//                System.out.println("j:"+j);
//                System.out.println("i:"+i);

//                System.out.println("dp:"+dp[j][i]);
            }
        }
        System.out.println(dp[1][n-1]);
    }
}
