package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-02 12:08
 * @Email xjwhhh233@outlook.com
 */
public class LastRemaining {
    public int lastRemaining(int n, int m) {
        int flag = 0;
        for (int i = 2; i <= n; i++) {
            flag = (flag + m) % i;
            //动态规划的思想，将f(n,m)替换成flag存储
        }
        return flag;
    }

    public int lastRemaining1(int n, int m){
        if(n < 1 || m < 1)
            return -1;
        if(n == 1)
            return 0;
        return (lastRemaining1(n-1, m) + m) % n;
    }

}
