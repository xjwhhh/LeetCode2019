/**
 * @Author JiaWei Xu
 * @Date 2020-02-29 10:54
 * @Email xjwhhh233@outlook.com
 */
public class LongestPalindromicSubstring {
    //预处理字符串
    //在每个字符间插入 "#"，在两端分别插入 "^" 和 "$"，这两个字符不会在字符串中出现
    //这样中心扩展的时候，判断两端字符是否相等的时候，如果到了边界就一定会不相等，跳出循环
    //并且经过处理，字符串的长度永远都是奇数
    private String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        StringBuilder ret = new StringBuilder("^");
        for (int i = 0; i < n; i++)
            ret.append("#").append(s.charAt(i));
        ret.append("#$");
        return ret.toString();
    }

    // 马拉车算法
    public String longestPalindrome(String s) {
        String str = preProcess(s);
        int tLen = str.length();
        int[] max = new int[tLen];// 中心扩展的最大长度
        int center = 0;// 回文串的中心
        int radius = 0;// 右半径
        for (int i = 1; i < tLen - 1; i++) {
            int i_mirror = 2 * center - i;
            if (radius > i) {
                max[i] = Math.min(radius - i, max[i_mirror]);// 防止超出右半径
            } else {
                max[i] = 0;// 等于右半径的情况
            }
            // 中心扩展
            while (str.charAt(i + 1 + max[i]) == str.charAt(i - 1 - max[i])) {
                max[i]++;
            }
            // 判断是否需要更新右半径
            if (i + max[i] > radius) {
                center = i;
                radius = i + max[i];
            }
        }
        // 找出max的最大值
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < tLen - 1; i++) {
            if (max[i] > maxLen) {
                maxLen = max[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2;// 原字符串下标
        return s.substring(start, start + maxLen);
    }


}
