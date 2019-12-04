package OJ2019.homework.review;

import java.util.*;

public class gre_5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            ArrayList<Integer> NArray = new ArrayList<>();
            ArrayList<Integer> MArray = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                NArray.add(scan.nextInt());
            }
            for (int j = 0; j < M; j++) {
                MArray.add(scan.nextInt());
            }
            helper(NArray, MArray);
        }
    }

    private static void helper(ArrayList<Integer> nArray, ArrayList<Integer> mArray) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int sum1 = 0;
        int sum2 = 0;

        while (i < nArray.size() && j < mArray.size()) {
            int tempN = nArray.get(i);
            int tempM = mArray.get(j);
            if (tempN < tempM) {
                sum1 += tempN;
                i++;
            } else if (tempN > tempM) {
                sum2 += tempM;
                j++;
            } else {
                sum += Math.max(sum1, sum2) + tempM;
                sum1 = sum2 = 0;
                i++;
                j++;
            }
        }
        if (i < nArray.size()) {
            for (int k = i; k < nArray.size(); k++) {
                sum1 += nArray.get(k);
            }
        }
        if (j < mArray.size()) {
            for (int k = j; k < mArray.size(); k++) {
                sum2 += mArray.get(k);
            }
        }
        sum += Math.max(sum1, sum2);
        System.out.println(sum);

    }
}
