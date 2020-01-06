import java.util.*;

/**
 * @Author JiaWei Xu
 * @Date 2020-01-05 16:58
 * @Email xjwhhh233@outlook.com
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (Integer integer:nums) {
            hashMap.put(integer, hashMap.getOrDefault(integer, 0) + 1);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(hashMap.entrySet());
        //然后通过比较器来实现排序
        list.sort(new Comparator<Map.Entry<Integer,Integer>>() {
            //升序排序
            public int compare(Map.Entry<Integer,Integer> o1,
                               Map.Entry<Integer,Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }

        });
        List<Integer> result=new ArrayList<>();
        int count=0;
        for(Map.Entry<Integer, Integer> entry:list){
            if(count<k){
                result.add(entry.getKey());
                count++;
            }else {
                break;
            }
        }
        return result;

    }
}
