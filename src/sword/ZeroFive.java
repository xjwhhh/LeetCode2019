package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-27 15:54
 * @Email xjwhhh233@outlook.com
 */
public class ZeroFive {
    public String replaceSpace(String s) {
        return s.replaceAll(" ","%20");

    }

    public String replaceSpace1(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }
}
