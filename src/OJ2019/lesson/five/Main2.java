package OJ2019.lesson.five;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
//            String temp=scan.nextLine();
//            String come = scan.nextLine();
//            String go = scan.nextLine();
//            int[] comArray=trans(come.split(" "));
//            int[] goArray=trans(go.split(" "));
            int N=scan.nextInt();
//            System.out.println(scan.nextInt());
//            System.out.println(scan.nextLine());
//            int N=6;
            int[] comArray=new int[N];
            int[] goArray=new int[N];
            for(int j=0;j<N;j++){
                comArray[j]=scan.nextInt();
            }
            for(int j=0;j<N;j++){
                goArray[j]=scan.nextInt();
            }
            helper(comArray,goArray);
        }
    }

    private static void helper(int[] come,int[] go){
        int[] helper=new int[2400];
        for(int i=0;i<come.length;i++){
            int a=come[i];
            int b=go[i];
            for(int j=a;j<=b;j++){
                helper[j]++;
            }
        }
        int max=0;
        for(int i=0;i<helper.length;i++){
            if(helper[i]>max){
                max=helper[i];
            }
        }
        System.out.println(max);
    }

    private static int[] trans(String[] array){
        int[] result=new int[array.length];
        for(int i=0;i<array.length;i++){
//            System.out.println(array[i]);
            result[i]=Integer.parseInt(array[i]);
        }
        return result;
    }
}
