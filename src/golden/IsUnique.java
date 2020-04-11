package golden;

import java.util.HashSet;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-02 13:05
 * @Email xjwhhh233@outlook.com
 */
public class IsUnique {
    public boolean isUnique(String astr) {
        HashSet<Character> hashSet=new HashSet<>();
        char[] chars=astr.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(!hashSet.add(chars[i])){
                return false;
            }
        }
        return true;

    }

    public boolean isUnique1(String astr) {
            long low64 = 0;
            long high64 = 0;

            for (char c : astr.toCharArray()) {
                if (c >= 64) {
                    long bitIndex = 1L << c - 64;
                    if ((high64 & bitIndex) != 0) {
                        return false;
                    }

                    //将对应下标置为1
                    high64 |= bitIndex;
                } else {
                    long bitIndex = 1L << c;
                    if ((low64 & bitIndex) != 0) {
                        return false;
                    }

                    low64 |= bitIndex;
                }

            }

            return true;
    }

}
