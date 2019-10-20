package homework.one;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for(int i=0;i<num;i++){
            String arrayString=scan.nextLine();
            String[] array=arrayString.split(" ");
            int len=Integer.parseInt(scan.nextLine());
            helper(array,len);

        }

    }

    private static void helper(String[] array,int len){
        int result=0;
        for(int i=0;i<array.length-len+1;i++){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<len;j++){
                int temp=Integer.parseInt(array[i+j]);
                if(temp>max){
                    max=temp;
                }
            }
            result+=max;
        }
        System.out.println(result);
    }
}
