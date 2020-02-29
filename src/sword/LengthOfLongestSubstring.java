package sword;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-29 16:56
 * @Email xjwhhh233@outlook.com
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hashMap=new HashMap<>();
        int flag=0;
        char[] array=s.toCharArray();
        int count=0;
        int max=0;
        for(int i=0;i<array.length;i++){
            char c=array[i];
            if(hashMap.containsKey(c)){
                //todo 要把这个重复字符之前的记录都删掉
                if(hashMap.get(c)>flag) {
                    count -= i - hashMap.get(c);
                    flag=hashMap.get(c);
//                count++;
                    hashMap.put(c, i);

                }else{
                    hashMap.put(c,i);
                    count++;
                    max=Math.max(count,max);
                }
            }else{
               hashMap.put(c,i);
                count++;
                max=Math.max(count,max);
            }
        }
        return max;

    }
    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int strLen = s.length(), start = 0, res = 0;
        for (int i = 0; i < strLen; ++i) {
            start = Math.max(start, map.getOrDefault(s.charAt(i), -1) + 1);
            map.put(s.charAt(i), i);
            res = Math.max(res, i - start + 1);
        }
        return res;
    }


}
