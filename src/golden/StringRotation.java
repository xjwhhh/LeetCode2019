package golden;

/**
 * @Author JiaWei Xu
 * @Date 2020-04-11 20:38
 * @Email xjwhhh233@outlook.com
 */
public class StringRotation {
    public boolean isFlipedString(String s1, String s2) {
        if(s1==null||s2==null||s1.length()!=s2.length()){
            return false;
        }
        return (s1+s1).contains(s2);

    }
}
