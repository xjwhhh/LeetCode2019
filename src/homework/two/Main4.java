package homework.two;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String arrayString=scan.nextLine();
            String[] arrayStr=arrayString.split(" ");
            int[] array=new int[arrayStr.length-1];
            for(int j=0;j<array.length;j++){
                array[j]=Integer.parseInt(arrayStr[j+1]);
            }
//            shellSort(array);
            insertSort(array);
            print(array);
        }
    }

    private static void insertSort(int[] array){
        for(int i=1;i<array.length;i++){
            int temp=array[i];
            int j=i-1;
            for(;j>=0;j--){
                if(array[j]>temp){
                    array[j+1]=array[j];
                }else{
                    break;
                }
            }
            array[j+1]=temp;
        }


    }

    private static void shellSort(int[] array){
        int N=array.length;
        for(int gap=N/2;gap>0;gap/=2){
            for(int i=gap;i<N;i++){
                insertI(array,gap,i);
            }
        }
    }

    private static void insertI(int[] array,int gap,int i){
        int temp=array[i];
        int j;
        for(j=i-gap;j>=0;j-=gap){
            if(array[j]>temp){
                array[j+gap]=array[j];
            }else{
                break;
            }
        }
        array[j+gap]=temp;
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
