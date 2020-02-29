package sword;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-29 15:30
 * @Email xjwhhh233@outlook.com
 */
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<arr.length;i++){
            if(queue.size()<k){
                queue.add(arr[i]);
            }else{
                queue.add(arr[i]);
                queue.poll();
            }
        }
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            if(!queue.isEmpty()) {
                result[i] = queue.poll();
            }
        }
        return result;


    }

    public int[] getLeastNumbers1(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr,k);
    }
}
