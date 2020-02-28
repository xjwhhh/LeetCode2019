package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-28 11:49
 * @Email xjwhhh233@outlook.com
 */
public class MyPow {
    //快速幂
    public double myPow(double x, int n) {
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
