package lesson.three;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            int index=scan.nextInt();
            helper(index);
        }
    }

    private static void helper(int index){
        if(index<2){
            System.out.println(1);
            return;
        }
        if(index==2){
            System.out.println(2);
            return;
        }
        long zero=1;
        long one=0;
        long two=1;
        for(int i=3;i<=index;i++){
            long tempZero=two+one;
            tempZero%=(1000000007);



            long tempOne=zero;
            tempOne%=(1000000007);
            long tempTwo=two+one;
            tempTwo%=(1000000007);
//            System.out.println(tempZero);
//            System.out.println(tempOne);
//            System.out.println(tempTwo);
            zero=tempZero;
            one=tempOne;
            two=tempTwo;
        }
        long count=one+two+zero;
        System.out.println(Math.floorMod(count,(long)Math.pow(10,9)+7));
//        System.out.println();

    }

}
