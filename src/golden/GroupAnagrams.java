package golden;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-03 10:39
 * @Email xjwhhh233@outlook.com
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> helper=new HashMap<>();
        if(strs==null||strs.length==0){
            return new ArrayList<>();
        }
        for (String str:strs) {
            int[] count=new int[26];
            for(int i=0;i<str.length();i++){
                count[str.charAt(i)-'a']++;
            }
            StringBuilder stringBuilder=new StringBuilder();
            for(int num:count){
                stringBuilder.append(num);
            }
            String temp=stringBuilder.toString();
            if(helper.containsKey(temp)){
                List<String> list=helper.get(temp);
                list.add(str);
                helper.put(temp,list);
            }else{
                List<String> list=new LinkedList<>();
                list.add(str);
                helper.put(temp,list);
            }
        }
        return new ArrayList<>(helper.values());
    }
}
