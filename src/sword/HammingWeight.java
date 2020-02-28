package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-28 11:37
 * @Email xjwhhh233@outlook.com
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public int hammingWeight1(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }

}
