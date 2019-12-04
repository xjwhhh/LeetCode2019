package OJ2019.homework.review;

import java.util.Scanner;

public class Dyp1 {
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

    }

    private static int[] trans(String[] array){
        int[] result=new int[array.length];
        for(int i=0;i<array.length;i++){
            result[i]=Integer.parseInt(array[i]);
        }
        return result;
    }
}
