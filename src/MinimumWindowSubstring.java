import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    //wrong 有一个超时了，应该是判断是否包含的时候效率太低
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        HashMap<Character,Integer> bMap=new HashMap<>();
        for(int i=0;i<t.length();i++){
            bMap.put(t.charAt(i),bMap.getOrDefault(t.charAt(i),0)+1);
        }
        if(s.length()==t.length()){
            if(helper(s,bMap)){
                return s;
            }else{
                return "";
            }
        }

        int min=Integer.MAX_VALUE;
        String result="";
        for(int i=0,j=t.length();j<=s.length();j++){
            String temp=s.substring(i,j);
            System.out.println(temp);

            if(helper(temp,bMap)){
                System.out.println("1"+temp);
                if(j-i<min){
                    result=s.substring(i,j);
                    System.out.println("5"+result);
                    min=j-i;
                }
                for(i=i+1;i<j;i++){
                    temp=s.substring(i,j);
                    System.out.println("2"+temp);
                    if(!helper(temp,bMap)){
                        if(j-i+1<min){
                            result=s.substring(i-1,j);
                            System.out.println("3"+result);
                            min=j-i+1;
                        }else{
                            System.out.println("4"+s.substring(i-1,j));
                        }
                        break;
                    }else if(temp.length()<min){
                        result=temp;
                        System.out.println("6"+result);
                        min=result.length();
                    }
                }
            }

        }
        return result;

    }

    private boolean helper(String a,HashMap<Character,Integer> bMap){
        HashMap<Character,Integer> aMap=new HashMap<>();

        for(int i=0;i<a.length();i++){
            aMap.put(a.charAt(i),aMap.getOrDefault(a.charAt(i),0)+1);
        }

        for(Map.Entry<Character,Integer> bEntry:bMap.entrySet()){
            if(!aMap.containsKey(bEntry.getKey())){
                return false;
            }else if(aMap.get(bEntry.getKey())<bEntry.getValue()){
                return false;
            }
        }
        return true;
    }

    public String minWindow2(String s,String t){
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int required = dictT.size();

        // Left and Right pointer
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and co***act the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            // Keep expanding the window once we are done co***acting.
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);

    }
}
