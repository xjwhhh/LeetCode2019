package OJ2019.homework.reviewer;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < times; i++) {
            int len = Integer.parseInt(sc.nextLine());

            String[] str = sc.nextLine().split(" ");
            int[] arr = new int[str.length];
            if (len == 0) {
                System.out.println(0);
                return;
            }
            for (int j = 0; j < str.length; j++) {
                arr[j] = Integer.parseInt(str[j]);
            }
            System.out.println(InversePairs(arr));
//            System.out.println(cnt);
        }
    }

    public static int InversePairs(int[] array) {

        return InversePairs(array, 0, array.length - 1);
    }

    public static int InversePairs(int[] arr, int left, int right) {
        if (left >= right)
            return 0;
        int mid = left + (right - left) / 2;
        int a = InversePairs(arr, left, mid);
        int b = InversePairs(arr, mid + 1, right);
        int c = merge(arr, left, mid, right);
        return (a + b + c);
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int a1 = left;
        int a2 = mid + 1;
        int times = 0;
        while (a1 <= mid && a2 <= right) {
            if (arr[a1] <= arr[a2]) {
                help[i++] = arr[a1++];
            } else {
                times += (mid - a1 + 1);
                help[i++] = arr[a2++];
            }
        }
        while (a1 <= mid) {
            help[i++] = arr[a1++];
        }
        while (a2 <= right) {
            help[i++] = arr[a2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[left++] = help[j];
        }

        return times;

    }
}