package OJ2019.homework.review;

import java.util.Scanner;

public class dyp_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        for (int i = 0; i < total; i++) {
            int n=scanner.nextInt();
            helper(n);
        }
    }

    private static void helper(int n){
        int[] C=new int[Math.max(4,new Double(Math.pow(n*n,3)).intValue()+1)];
//        System.out.println(C.length);
        C[0]=2;
        C[1]=2;
        C[2]=1;
        C[3]=1;
        for(int i=4;i<C.length;i++){
            C[i]=3*C[i-1]+5*C[i-3];
            System.out.println(C[i]);
            if(C[i]%2==0){
                C[i]=2;
            }else{
                C[i]=1;
            }
        }
        int result=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int temp=new Double(Math.pow(i*j,3)).intValue();
                if(C[temp]%2==1){
                    result++;
                }
            }
        }
        System.out.println(result);

    }
}
