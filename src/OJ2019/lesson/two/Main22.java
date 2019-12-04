package OJ2019.lesson.two;

import java.util.*;

/**
 * T2
 * Usage:
 *
 * @author heleninsa
 * create time 2019/9/26 - 10:35 AM
 */
public class Main22 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        for (int i = 0; i < c; i ++) {
            int num = scanner.nextInt();
            if (num == 0 || num == 1) {
                System.out.println(0);
            }
            int[] data = new int[num];
            int[] cp = new int[num];
            for (int j = 0; j < num; j ++) {
                data[j] = scanner.nextInt();
                cp[j] = data[j];
            }
            System.out.println(solve(data, cp));
        }
    }

    public static int solve(int[] data, int[] cp) {
        Arrays.sort(cp);
        int c = 0;
        int s = 0;
        while (s < data.length) {
            if (data[s] == cp[s]) {
                s ++;
            } else {
                for (int i = s; i < cp.length; i ++) {
                    // to avoid dup
                    if (cp[i] == data[s] && data[i] != data[s]) {
                        //
                        data[s] = data[i];
                        data[i] = cp[i];
                        c ++;
                        break;
                    }
                }
            }
        }

        return c;
    }

}
