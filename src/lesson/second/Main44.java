package lesson.second;

import java.util.Scanner;

public class Main44 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        for (int i = 0; i < num; i++) {
            long n = scan.nextLong();
            System.out.println(countNumbers(n));
        }
    }

    private static int countNumbers(long n) {
        int c = 0;

        long limit = (long) Math.sqrt(n);

        long[] prime = new long[(int) (limit + 1)];

        for (int i = 1; i <= limit; i++) {
            prime[i] = i;
        }

        for (int i = 2; i * i <= limit; i++) {
            if (prime[i] == i) {
                for (int j = i * i; j <= limit; j += i) {
                    if (prime[j] == j) {
                        prime[j] = i;
                    }
                }
            }
        }

        for (int i = 2; i <= limit; i++) {
            long p = prime[i];
            long q = prime[(int) (i / prime[i])];
            if (p * q == i && p!=1&& q != 1 && p != q) {
                c += 1;
            } else if (prime[i] == i) {
                if (new Double(Math.pow(i, 8)).longValue() <= n) {
                    c += 1;
                }
            }
        }
        return c;
    }


}
