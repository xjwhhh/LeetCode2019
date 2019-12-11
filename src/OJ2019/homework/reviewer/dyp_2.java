package OJ2019.homework.reviewer;


import java.util.Scanner;

public class dyp_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        for(int i=0;i<total;i++){
            int n=scanner.nextInt();

            int []A = new int[n];

            for(int j=0;j<n;j++){
                A[j]=scanner.nextInt();
            }

            helper(A);
        }
    }

    private static void helper(int[] A){
        int[] F=new int[A.length];
        int[] D=new int[A.length];
        int maxF=A[0];
        int maxFCurr=A[0];
        F[0]=A[0];
        for(int i=1;i<A.length;i++){
            maxFCurr=Math.max(A[i],maxFCurr+A[i]);
            maxF=Math.max(maxF,maxFCurr);
            F[i]=maxFCurr;
        }
        int maxD=A[A.length-1];
        int maxDCurr=A[A.length-1];
        D[A.length-1]=A[A.length-1];
        for(int i=A.length-2;i>=0;i--){
            maxDCurr=Math.max(A[i],maxDCurr+A[i]);
            maxD=Math.max(maxD,maxDCurr);
            D[i]=maxDCurr;
        }
        int max=Math.max(maxD,maxF);
        for(int i=1;i<A.length-1;i++){
            max=Math.max(max,F[i-1]+D[i+1]);
        }
        System.out.println(max);


    }
}
