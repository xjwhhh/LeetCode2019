package lesson.one;

import java.util.Scanner;

public class Main { // 注意类名必须为Main
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num=scan.nextInt();
        while(scan.hasNext()){
            String[] nums = scan.nextLine().split(" ");
            int sum = 0;
            for(String num_s: nums){
                sum += Integer.parseInt(num_s);
            }
            System.out.println(sum);
        }
    }
}
