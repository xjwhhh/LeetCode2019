package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-02 10:53
 * @Email xjwhhh233@outlook.com
 */
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        if(s==null||s.length()<n){
            return null;
        }
        int len=s.length();
        String left=s.substring(0,n-1);
        String right=s.substring(n,s.length());
        return right+left;

    }
}
