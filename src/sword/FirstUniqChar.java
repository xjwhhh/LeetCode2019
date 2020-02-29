package sword;

import java.util.*;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-29 17:28
 * @Email xjwhhh233@outlook.com
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            hashMap.put(s.charAt(i),hashMap.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(hashMap.get(s.charAt(i))==1){
                return s.charAt(i);
            }
        }
        return ' ';


    }
}
