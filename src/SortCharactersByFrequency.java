import java.util.*;

/**
 * @Author JiaWei Xu
 * @Date 2020-01-05 16:45
 * @Email xjwhhh233@outlook.com
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if(s==null){
            return null;
        }
        char[] chars=s.toCharArray();
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for (Character character : chars) {
            hashMap.put(character, hashMap.getOrDefault(character, 0) + 1);
        }

        List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(hashMap.entrySet());
        //然后通过比较器来实现排序
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            //升序排序
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }

        });
        StringBuilder stringBuilder=new StringBuilder();
        for(Map.Entry<Character, Integer> entry:list){
            for(int i=0;i<entry.getValue();i++){
                stringBuilder.append(entry.getKey());
            }
        }
        return stringBuilder.toString();





    }
}
