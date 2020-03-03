import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-03 15:17
 * @Email xjwhhh233@outlook.com
 */
public class LRUCache {

    LinkedHashMap<Integer,Integer> hashMap;
    int capacity;
    LinkedList<Integer> linkedList;

    public LRUCache(int capacity) {
        hashMap=new LinkedHashMap<>(capacity);
        linkedList=new LinkedList<>();
        this.capacity=capacity;

    }

    public int get(int key) {
        if(hashMap.containsKey(key)){
            linkedList.remove((Integer)key);
            linkedList.add(key);
            return hashMap.get(key);
        }
        return -1;

    }

    public void put(int key, int value) {
        if(hashMap.containsKey(key)){
            hashMap.put(key,value);
            linkedList.remove((Integer)key);
            linkedList.add(key);
        }else{
            if(hashMap.size()<capacity){
                hashMap.put(key,value);
                linkedList.add(key);
            }else{
                if(!linkedList.isEmpty()) {
                    int removeKey = linkedList.poll();
                    hashMap.remove(removeKey);
                    linkedList.add(key);
                    hashMap.put(key,value);
                }
            }
        }

    }
}
