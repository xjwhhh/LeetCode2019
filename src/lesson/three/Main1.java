package lesson.three;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String numStr=scan.nextLine();
           System.out.println(helper(numStr));

        }
    }

    private static int helper(String numStr){
        char[] arrayStr=numStr.toCharArray();
        int[] array=new int[arrayStr.length];
        for(int i=0;i<arrayStr.length;i++){
            array[i]=Integer.parseInt(String.valueOf(arrayStr[i]));
        }

        int temp=0;
        if(array.length%2==0){
            temp=array.length;
        }else{
            temp=array.length-1;
        }

        for(int len=temp;len>=2;len-=2){
            for(int i=0;i+len<=array.length;i++){
                int start=i;
                int end=i+len-1;
                int leftSum=0;
                int rightSum=0;
                for(int j=0;j<len/2;j++){
                    leftSum+=array[start+j];
                }
                for(int j=0;j<len/2;j++){
                    rightSum+=array[end-j];
                }
                if(leftSum==rightSum){
                    return len;
                }

            }

        }
        return 0;

    }

}
