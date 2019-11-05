package homework.two;

import java.util.*;
import java.util.stream.Collectors;


public class Main11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        for (int c = 0; c < cases; c++) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();
            int rows = arr1.length + 1;
            int cols = arr2.length + 1;

            int[][] dp = new int[rows][cols];
            String[][] keys = new String[rows][cols];
            Map<String, List<String>> lcsMap = new HashMap<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    keys[i][j] = UUID.randomUUID().toString();
                    List<String> init = new LinkedList<>();
                    init.add("");
                    lcsMap.put(keys[i][j], init);
                }
            }
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < cols; j++) {
                    if (arr1[i - 1] == arr2[j - 1]) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        List<String> old = lcsMap.get(keys[i - 1][j - 1]);
                        List<String> now = new LinkedList<>();
                        for (String s : old) {
                            now.add(s + arr1[i - 1]);
                        }
                        lcsMap.put(keys[i][j], now);
                    } else {
                        if (dp[i][j - 1] == dp[i - 1][j]) {
                            dp[i][j] = dp[i][j - 1];
                            Set<String> now = new HashSet<>();
                            now.addAll(lcsMap.get(keys[i][j - 1]));
                            now.addAll(lcsMap.get(keys[i - 1][j]));
                            lcsMap.put(keys[i][j], new LinkedList<>(now));
                        } else if (dp[i][j - 1] > dp[i - 1][j]) {
                            dp[i][j] = dp[i][j - 1];
                            List<String> now = new LinkedList<>(lcsMap.get(keys[i][j - 1]));
                            lcsMap.put(keys[i][j], now);
                        } else {
                            dp[i][j] = dp[i - 1][j];
                            List<String> now = new LinkedList<>(lcsMap.get(keys[i - 1][j]));
                            lcsMap.put(keys[i][j], now);
                        }
                    }
                }
            }
            List<String> results = lcsMap.get(keys[rows - 1][cols - 1]).stream()
                    .filter(s -> !s.isEmpty())
                    .sorted()
                    .collect(Collectors.toList());
            for (String res : results) {
                System.out.println(res);
            }
        }
    }

}
