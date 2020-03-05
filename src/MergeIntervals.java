import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> result=new ArrayList<>();
        if(intervals==null||intervals.length==0||intervals[0].length==0){
            return new int[0][0];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        int[] save=intervals[0];
        result.add(save);
        for(int i=1;i<intervals.length;i++){
            int[] scan=intervals[i];
            if(scan[0]<=save[1]){
                save[1]=Math.max(save[1],scan[1]);
            }else{
                save=scan;
                result.add(save);
            }
        }
        if(!result.contains(save)){
            result.add(save);
        }
        return result.toArray(new int[result.size()][]);


    }
}
