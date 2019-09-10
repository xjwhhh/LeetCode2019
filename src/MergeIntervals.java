import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    //wrong,类似[[1,4],[5,6]]的话，4，5之间有空隙，不能连在一起
//    public int[][] merge(int[][] intervals) {
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < intervals.length; i++) {
//            if (intervals[i][0] < min) {
//                min = intervals[i][0];
//            }
//            if (intervals[i][1] > max) {
//                max = intervals[i][1];
//            }
//
//        }
//        boolean[] board = new boolean[max - min + 1];
//        // System.out.println(board.length);
//        Arrays.fill(board, false);
//        for (int i = 0; i < intervals.length; i++) {
//            int low = intervals[i][0] - min;
//            int high = intervals[i][1] - min;
//            // System.out.println(low);
//            // System.out.println(high);
//            for (int j = low; j <= high; j++) {
//                board[j] = true;
//            }
//
//        }
//        for (int i = 0; i < board.length; i++) {
//            System.out.println(i + ":" + board[i]);
//
//
//        }
//        List<List<Integer>> list = new ArrayList<>();
//        int start = 0;
//        boolean end = true;
//        for (int i = 0; i < board.length; i++) {
//            System.out.println(i + ":" + board[i]);
//
//
//            System.out.println(end);
//
//
//            if ((!board[i] || i == board.length - 1) && !end) {
//
//                List<Integer> temp = new ArrayList<>();
//                temp.add(start + min);
//                if (i == board.length - 1) {
//                    temp.add(i + min);
//                } else {
//                    temp.add(i - 1 + min);
//                }
//                list.add(temp);
//                end = true;
//                System.out.println(start + min);
//                System.out.println(i - 1 + min);
//                // continue;
//            } else if (board[i]) {
//                if (end) {
//                    start = i;
//                    end = false;
//                }
//            }
//        }
//
//        int[][] result = new int[list.size()][2];
//        for (int i = 0; i < list.size(); i++) {
//            int[] temp = {list.get(i).get(0), list.get(i).get(1)};
//            result[i] = temp;
//        }
//        return result;
//
//    }
}
