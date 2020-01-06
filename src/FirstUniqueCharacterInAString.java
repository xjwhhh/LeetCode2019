import java.util.HashMap;
import java.util.Map;

/**
 * @Author JiaWei Xu
 * @Date 2020-01-05 16:36
 * @Email xjwhhh233@outlook.com
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if(s==null||s.length()==0){
            return -1;
        }
        int length=s.length();
        char[] chars=s.toCharArray();
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for(int i=0;i<chars.length;i++){
            Character character=chars[i];
            if(hashMap.containsKey(character)){
                hashMap.put(character, length);
            }else{
                hashMap.put(character,i);
            }
        }
        int min=length;
        for(Map.Entry<Character,Integer> entry:hashMap.entrySet()){
            if(entry.getValue()!=length&&entry.getValue()<min){
                min=entry.getValue();
            }
        }
        if(min==length){
            return -1;
        }else {
            return min;
        }


    }
}
