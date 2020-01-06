import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author JiaWei Xu
 * @Date 2020-01-05 17:09
 * @Email xjwhhh233@outlook.com
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums==null||nums.length==0){
            return -1;
        }
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for(int num:nums){
            priorityQueue.add(num);
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();

    }
}
