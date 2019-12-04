package OJ2019.homework.two;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            String arrayString = scan.nextLine();
            String[] arrayStr = arrayString.split(" ");
            int[] array = new int[arrayStr.length-1];
            for (int j = 0; j < array.length; j++) {
                array[j] = Integer.parseInt(arrayStr[j+1]);
            }
            int[] result=countingSort(array);
            print(result);


        }
    }

    private static int[] countingSort(int[] array){
        int[] result=new int[array.length];
        for(int i=0;i<array.length;i++){
            int count=0;
            int same=0;
            for(int j=0;j<array.length;j++){
                if(array[i]>array[j]){
                    count++;
                }
                if(array[i]==array[j]){
                    same++;
                }
            }
            for(int j=0;j<same;j++) {
                result[count+j] = array[i];
            }
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
