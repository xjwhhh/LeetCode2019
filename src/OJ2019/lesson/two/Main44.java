package OJ2019.lesson.two;

import java.util.*;

public class Main44 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num_of_test_case = scanner.nextInt();
        for (int i = 0; i < num_of_test_case; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            List<Integer> data1 = new ArrayList<>(num1);
            for (int j = 0; j < num1; j++) {
                data1.add(scanner.nextInt());
            }
            HashMap<Integer, Integer> data2 = new HashMap<>();
            for (int j = 0; j < num2; j++) {
                data2.put(scanner.nextInt(), j);
            }
            if (num1 == 0) {
                System.out.println();
                continue;
            }

        }
    }

    private static void helper(List<Integer> data1, HashMap<Integer, Integer> data2) {
        data1.sort((o1, o2) -> {
            if (data2.containsKey(o1) && data2.containsKey(o2)) {
                return data2.get(o1) - data2.get(o2);
            } else if (data2.containsKey(o1)) {
                return -1;
            } else if (data2.containsKey(o2)) {
                return 1;
            } else {
                return o1 - o2;
            }
        });
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < data1.size(); j++) {
            builder.append(data1.get(j) + " ");
        }
        String str = builder.toString();
        System.out.println(str.substring(0, str.length() - 1));
    }

}
