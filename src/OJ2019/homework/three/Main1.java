package OJ2019.homework.three;

import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(scan.nextLine());
            String str=scan.nextLine();
            String[] array=str.split(",");
            int[][] costs=new int[n][n];
            for(int j=0;j<array.length;j++){
                String[] temp=array[j].split(" ");
                int worker=Integer.parseInt(temp[0]);
                int work=Integer.parseInt(temp[1]);
                int cost=Integer.parseInt(temp[2]);
                costs[worker-1][work-1]=cost;
            }
            dp(costs,n);


        }
    }

    private static void dp(int[][] costs,int n){
        int[][] dp=new int[n+1][n+1];

    }
}
