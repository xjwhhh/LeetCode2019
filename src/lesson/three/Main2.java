package lesson.three;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String numStr=scan.nextLine();
            String str1=scan.nextLine();
            String str2=scan.nextLine();
            int[] num1=string2Int(str1);
            int[] num2=string2Int(str2);
            int[] result=helper(num1,num2);
            print(result);
        }
    }

    private static int[] string2Int(String str){
        String[] temp=str.split(" ");
        int[] result=new int[temp.length];
        for(int i=0;i<result.length;i++){
            result[i]=Integer.parseInt(temp[i]);
        }
        return result;
    }
    private static int[] helper(int[] num1,int[] num2){
        int[] result=new int[num2.length];
        for(int i=0;i<num2.length;i++){
            int count=0;
            for(int j=0;j<num1.length;j++){
                if(num1[j]%num2[i]==0){
                    count++;
                }
            }
            result[i]=count;

        }
        return result;
    }

    private static void print(int[] array){
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
