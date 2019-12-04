package OJ2019.homework.review;

import java.util.Scanner;

public class sor_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        for(int i=0;i<total;i++){
            int n=scanner.nextInt();

            int[] A=new int[n];

            for(int j=0;j<n;j++){
                A[j]=scanner.nextInt();
            }

            helper(A);
        }
    }

    private static void helper(int[] A){
        int count=0;
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                if(A[i]>A[j]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
