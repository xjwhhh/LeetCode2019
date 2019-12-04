package OJ2019.lesson.two;

import java.util.*;
public class Main11 {

    static class Node {
        int v;
        int c;

        public Node(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        for (int i = 0; i < c; i ++) {
            int num = scanner.nextInt();
            HashMap<Integer, Node> data = new HashMap<>();
            for (int j = 0; j < num; j ++) {
                int d = scanner.nextInt();
                if (data.containsKey(d)) {
                    data.get(d).c++;
                } else {
                    data.put(d, new Node(d, 1));
                }
            }
            // PriorityQueue<Node> pq = new PriorityQueue<>(data.values());
            List<Node> re = new ArrayList<>(data.values());
            re.sort((o1, o2) -> o1.c < o2.c ? 1 : (o1.c == o2.c ? o1.v - o2.v : -1));
            StringBuilder builder = new StringBuilder();
            for (Node it: re) {
                for (int j = 0; j < it.c; j ++) {
                    builder.append(it.v + " ");
                }
            }
            String  reS = builder.toString();
            if (reS.isEmpty()) {
                System.out.println();
            } else {
                System.out.println(reS.substring(0, reS.length() - 1));
            }
        }
    }
}