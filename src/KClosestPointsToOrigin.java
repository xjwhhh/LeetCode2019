import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Author JiaWei Xu
 * @Date 2020-01-05 17:20
 * @Email xjwhhh233@outlook.com
 */
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        HashMap<int[],Integer> hashMap=new HashMap<>();
        for(int i=0;i<points.length;i++){
            int[] rPoint=points[i];
            int length=new Double(Math.pow(rPoint[0],2)+Math.pow(rPoint[1],2)).intValue();
            hashMap.put(rPoint,length);
        }

        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return hashMap.get(o2)-hashMap.get(o1);
            }
        });
        for(int i=0;i<points.length;i++){
            priorityQueue.add(points[i]);
            if(priorityQueue.size()>K){
                priorityQueue.poll();
            }
        }
        int[][] result=new int[K][2];
        for(int i=0;i<priorityQueue.size();i++){
            result[i]=priorityQueue.poll();
        }

        return result;

    }
}
