package lesson.three;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            long index=scan.nextLong();
            helper1(index);
        }
    }

    private static void helper(long index){
        StringBuilder str=new StringBuilder("12345");
        String pre="12345";
        String reverse="54321";
        long end=5;
        long count=1;
        while(end<index){
//            pre=str.toString();
//            System.out.println(pre);
            end+=(count+reverse.length());

            for(long i=0;i<count;i++){
                str.append("$");
            }
            str.append(reverse);
            reverse=str.reverse().toString();
//            System.out.println(reverse);
            count++;

        }
//        System.out.println(count);
        int t=(int)(end-index);
//        System.out.println(t);
//        if(0<=t&&t<5) {
//            System.out.println(str.charAt(pre.length() - t - 1));
//        }else{
//            System.out.println("$");
//        }
        System.out.println(str.charAt(str.length() - t - 1));
    }

    private static void helper1(long index){
        long end=5;
        long count=1;
        while(end<index){
            end=(end+count)*2;
        }

    }
}
