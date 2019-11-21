package lesson.four;

import java.util.Scanner;

public class Main11 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int cas = scanner.nextInt();
        while (cas>0){
            int n =  scanner.nextInt();
            int[] arr = new int[n];

            for(int i =0;i<n;i++){
                arr[i] = scanner.nextInt();
            }

            int[] end_here = new int[n];
            int[] start_here = new int[n];
            int max_sum = arr[0];
            end_here[0] = arr[0];
            for (int i = 1; i < n; i++) {
                end_here[i] = Math.max(arr[i], end_here[i - 1] + arr[i]);
                max_sum = Math.max(max_sum, end_here[i]);
            }
            start_here[n - 1] = arr[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                start_here[i] =Math.max(arr[i], start_here[i + 1] + arr[i]);
            }
            for (int i = 1; i < n - 1; i++) {
                max_sum = Math.max(max_sum, end_here[i - 1] + start_here[i + 1]);
            }
            System.out.println(max_sum);
            cas--;

        }
    }
}