package OJ2019.homework.two;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String str=scan.nextLine();
            String[] array=str.split(" ");
            helper(array);
        }
    }

    private static void helper(String[] array){
        if(array[0].equals("0")|array[0].equals("1")){
            System.out.println(true);
            return;
        }
        int left=1;
        int right=array.length-1;
        while(left<right){
            if(!array[left].equals(array[right])){
                System.out.println(false);
                return;
            }else{
                left++;
                right--;
            }
        }
        System.out.println(true);
    }
}
