package lesson.second;


import java.math.BigInteger;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num=scan.nextInt();
        for(int i=0;i<num;i++){

            int a=scan.nextInt();
            int b=scan.nextInt();
            int c=scan.nextInt();
            helper(a,b,c);

        }
    }

    private static void helper(int a,int b,int c){
        if(a%c==0){
            System.out.println(0);
        }else {
            Long temp=new Double(Math.pow(a, b)).longValue();
            BigInteger A=new BigInteger(String.valueOf(a));
            BigInteger C=new BigInteger(String.valueOf(c));
            System.out.println(A.pow(b).remainder(C));


//            System.out.println(temp);

//            System.out.println(temp % c);
        }

    }
}
