package golden;

import java.util.HashSet;

/**
 * @Author JiaWei Xu
 * @Date 2020-04-11 19:42
 * @Email xjwhhh233@outlook.com
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if(s==null||s.length()<1){
            return false;
        }
       char[] chars=s.toCharArray();
       int result=0;
       HashSet<Character> hashSet=new HashSet<>();
       for(char c:chars){
           if(hashSet.contains(c)){
               hashSet.remove(c);
           }else{
               hashSet.add(c);
           }
       }
       return hashSet.size()<=1;

    }
}
