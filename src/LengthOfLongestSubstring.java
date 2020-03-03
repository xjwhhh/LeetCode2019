import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-03 13:08
 * @Email xjwhhh233@outlook.com
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int res=0;
        HashSet<Character> hashSet=new HashSet<>();
        while(i<s.length()&&j<s.length()){
            if(!hashSet.contains(s.charAt(j))){
                hashSet.add(s.charAt(j));
                res=Math.max(res,j-i+1);
                j++;
            }else{
                hashSet.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }

    public int lengthOfLongestSubstring1(String s) {
        int i=0;
        int j=0;
        int res=0;
        HashMap<Character,Integer> hashMap=new HashMap<>();
        while(i<s.length()&&j<s.length()){
            if(!hashMap.containsKey(s.charAt(j))){
                hashMap.put(s.charAt(j),j);
                res=Math.max(res,j-i+1);
                j++;
            }else{
                i=Math.max(hashMap.get(s.charAt(j)),i);
                hashMap.put(s.charAt(j),j);
                res=Math.max(res,j-i+1);
                j++;
            }
        }
        return res;
    }

}
