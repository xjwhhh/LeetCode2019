package OJ2019.lesson.four;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String[] xianzhi=scan.nextLine().split(" ");
            int N=Integer.parseInt(xianzhi[0]);
            int X=Integer.parseInt(xianzhi[1]);
            int Y=Integer.parseInt(xianzhi[2]);
            String[] strR=scan.nextLine().split(" ");
            String[] strA=scan.nextLine().split(" ");
            int[] R=trans(strR);
            int[] A=trans(strA);
            helper(N,X,Y,R,A);
        }
    }

    private static void helper(int N,int X,int Y,int[] R,int[] A){
        int[][] dp=new int[N+1][N+1];
        for(int i=0;i<N+1;i++){
            dp[i][0]=0;
//            System.out.println(i);
//            System.out.println(A[i]);
        }
        for(int i=0;i<N+1;i++){
            dp[0][i]=0;
//            System.out.println(R[i]);
        }
        int count=1;


        for(int i=1;i<N+1;i++){
            count=i;
            for(int j=1;j<N+1;j++){
                if(count<=N){
//                    System.out.println("count"+count);

                    dp[i][j]=Math.max(dp[i-1][j]+R[count-1],dp[i][j-1]+A[count-1]);
//                    System.out.println("i"+i+"j"+j);
//                    System.out.println(dp[i][j]);
                    count++;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }


        }
        System.out.println(dp[N][N]);

    }

    private static int[] trans(String[] array){
        int[] result=new int[array.length];
        for(int i=0;i<array.length;i++){
//            System.out.println(array[i]);
            result[i]=Integer.parseInt(array[i]);
        }
        return result;
    }
}
