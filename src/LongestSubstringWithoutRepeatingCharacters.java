import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int result=0;
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for(int i=0,j=0;j<s.length();j++){
            if(hashMap.containsKey(s.charAt(j))){
                i = Math.max(hashMap.get(s.charAt(j)), i);
            }

            result = Math.max(result, j - i + 1);
            hashMap.put(s.charAt(j), j + 1);
        }

        return result;

    }

}
