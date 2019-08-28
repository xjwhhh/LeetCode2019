import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> need=new HashMap<>();
        for(int i=0;i<p.length();i++){
            need.put(p.charAt(i),need.getOrDefault(p.charAt(i),0)+1);
        }
        int required=need.size();
        int l = 0, r = 0;
        int have=0;
        List<Integer> result=new ArrayList<>();
        HashMap<Character,Integer> window=new HashMap<>();
        while(r<s.length()){
            char c = s.charAt(r);
            int count = window.getOrDefault(c, 0);
            window.put(c, count + 1);
            if(need.containsKey(c)&& need.get(c).equals(window.get(c))){
                have++;
            }
            if(l <= r && have == required &&r-l+1==p.length()) {
                result.add(l);
                c=s.charAt(l);
                window.put(c,window.get(c)-1);
                if(need.containsKey(c)&& !(need.get(c).equals(window.get(c)))){
                    have--;
                }
                l++;

            }
            r++;

        }
        return result;
    }
}
