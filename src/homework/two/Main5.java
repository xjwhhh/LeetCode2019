package homework.two;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            String arrayString = scan.nextLine();
            String[] arrayStr = arrayString.split(" ");
            int[] array = new int[arrayStr.length-1];
            for (int j = 0; j < array.length; j++) {
                array[j] = Integer.parseInt(arrayStr[j+1]);
            }
            bubbleSort(array);
            print(array);


        }
    }

    private static void bubbleSort(int[] array){
        int len=array.length;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<len-i-1;j++){
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
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
