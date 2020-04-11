package golden;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author JiaWei Xu
 * @Date 2020-04-11 19:27
 * @Email xjwhhh233@outlook.com
 */
public class CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        char[] array1=s1.toCharArray();
        char[] array2=s2.toCharArray();
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for(int i=0;i<array1.length;i++){
            hashMap.put(array1[i],hashMap.getOrDefault(array1[i],0)+1);
        }
        for(int i=0;i<array2.length;i++){
            if(!hashMap.containsKey(array2[i])||hashMap.get(array2[i])<=0){
                return false;
            }else{
                hashMap.put(array2[i],hashMap.get(array2[i])-1);
            }
        }
        return true;
    }

    public boolean CheckPermutation1(String s1, String s2) {
        char[] c1=s1.toCharArray();
        Arrays.sort(c1);
        char[] c2=s2.toCharArray();
        Arrays.sort(c2);
        return new String(c1).equals(new String(c2));
    }

}
