package lesson.four;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            int numSeller=Integer.parseInt(scan.nextLine());
            ArrayList<int[]> array=new ArrayList<>();
            for(int j=0;j<numSeller;j++){
                String[] costStr=scan.nextLine().split(" ");
                array.add(trans(costStr));
            }
            helper(array,numSeller);

        }
    }

    private static void helper(ArrayList<int[]> array,int N){
//        if(array.size()>=1){
//            ArrayList<Integer> indexArray=new ArrayList<>();
//            int[] pre=array.get(0);
//            int currentMax=min(pre,indexArray,0);
//            for(int i=1;i<array.size();i++){
//
//
//            }
//        }

        int[][] dp=new int[N+1][4];
        for(int i=0;i<N+1;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<4;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<N+1;i++){
//            for(int j=1;j<4;j++){
//                int[] temp=array.get(i-1);
//                dp[i][]=
//            }
            int[] temp=array.get(i-1);
            dp[i][1]=Math.min(dp[i-1][2]+temp[0],dp[i-1][3]+temp[0]);
            dp[i][2]=Math.min(dp[i-1][1]+temp[1],dp[i-1][3]+temp[1]);
            dp[i][3]=Math.min(dp[i-1][1]+temp[2],dp[i-1][2]+temp[2]);
        }

        int result=Math.min(Math.min(dp[N][1],dp[N][2]),dp[N][3]);
        System.out.println(result);


    }

    private static int min(int[] array,ArrayList<Integer> indexArray,int index){
        return Math.min(Math.min(array[0],array[1]),array[2]);
    }

    private static int[] trans(String[] array){
        int[] result=new int[array.length];
        for(int i=0;i<array.length;i++){
            result[i]=(Integer.parseInt(array[i]));
        }
        return result;
    }
}
