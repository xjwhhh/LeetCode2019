package OJ2019.homework.two;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String str=scan.nextLine();
            String[] array=str.split(" ");
            int num1=Integer.parseInt(array[0]);
            int num2=Integer.parseInt(array[array.length-1]);

            String[] newArray=new String[array.length-2];
            if (num1> 0) {
                System.arraycopy(array, 1, newArray, 0, array.length - 1 - 1);
                helper(newArray, num1, num2);
                print(newArray);
            }else{
                System.out.println();
            }
        }
    }

    private static void helper(String[] array,int num1,int num2){
        if(num1<num2||num2==1||num2==0){
            return;
        }
        for(int i=0;i<array.length;i+=num2){
            if(i+num2<=array.length){
                StringBuilder str=new StringBuilder();
                for(int j=i;j<i+num2;j++){
                    str.append(array[j]);
                }
                String res=new StringBuffer(str).reverse().toString();
                for(int j=i;j<i+num2;j++){
                    array[j]=res.substring(j-i,j-i+1);
                }
            }
        }
    }

    private static void print(String[] array){
        StringBuilder res=new StringBuilder();
        for(int j=0;j<array.length-1;j++){
            res.append(array[j]);
            res.append(" ");
        }
        if(array.length-1>=0) {
            res.append(array[array.length - 1]);
        }
        System.out.println(res);
    }
}
