package kixkstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class XorWhat {
    public static void main(String[] args){
        Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T=in.nextInt();
        for(int i=0;i<T;i++){
            int N=in.nextInt();
            int Q=in.nextInt();
            int[] array=new int[N];
            int[] change=new int[2*Q];
            for(int j=0;j<N;j++){
                array[j]=in.nextInt();
            }
            for(int j=0;j<2*Q;j++){
                change[j]=in.nextInt();
            }
            int[] y=new int[Q];
            for(int j=0;j<Q;j++){
                int index=change[2*j];
                int number=change[2*j+1];
                array[index]=number;
                int max=0;
                for(int a=0;a<N;a++){
                    int temp=array[a];
                    for(int b=a+1;b<N;b++){
                        temp=temp^array[b];
                        int count=count(temp);
                        if(count%2==0){
                            if(b-a+1>max){
                                max=b-a+1;
                            }
                        }

                    }
                }
                y[j]=max;
            }
            System.out.print("Case #"+(i+1)+": ");
            for(int j=0;j<Q-1;j++){
                System.out.print(y[j]+" ");
            }
            System.out.println(y[Q-1]+"");


        }

    }

    public static int count(int n){
        int res = 0;
        while(n != 0){
            n &= (n-1);
            res++;
        }
        return res;
    }




}
