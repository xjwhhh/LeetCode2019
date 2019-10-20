package homework.one;

import java.util.Scanner;

public class Main4 {
    static int count = 0;
    static char A = 'A';
    static char B = 'B';
    static char C = 'C';

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        for (int i = 0; i < num; i++) {
            count = 0;
            int n = scan.nextInt();
            hanoi(n, A, B, C);
            System.out.println(count);
        }
    }

    private static void hanoi(int n, char A, char B, char C) {
        if (n == 1) {
            count+=2;
        } else {
            hanoi(n - 1, A, B,C);
            count++;
            hanoi(n - 1, C, B, A);
            count++;
            hanoi(n - 1, A, B, C);
        }

    }

    private static void move() {//执行最大盘子的从A-C的移动
        count++;
    }


    public static void main1(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int cas = scanner.nextInt();
        while (cas > 0) {
            int n = scanner.nextInt();
            System.out.println(hano(n));
            cas--;
        }

    }

    public static int hano(int n) {
        if (n == 1) {
            return 2;
        } else return hano(n - 1) * 3 + 2;
    }


}
