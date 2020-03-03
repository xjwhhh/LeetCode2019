public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0){
            return " ";
        }
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            int len1=helper(s,i,i);
            int len2=helper(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>=end-start+1){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);

    }

    private int helper(String s,int left,int right){
        while(left>=0&&right<=s.length()-1){
            if(s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
        }
        return right-left-1;
    }

    private String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^";
        for (int i = 0; i < n; i++)
            ret += "#" + s.charAt(i);
        ret += "#$";
        return ret;
    }

    // 马拉车算法
    public String longestPalindrome2(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0;
        for (int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * C - i;
            if (R > i) {
                P[i] = Math.min(R - i, P[i_mirror]);// 防止超出 R
            } else {
                P[i] = 0;// 等于 R 的情况
            }

            // 碰到之前讲的三种情况时候，需要利用中心扩展法
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // 判断是否需要更新 R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }

        }

        // 找出 P 的最大值
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2; //最开始讲的求原字符串下标
        return s.substring(start, start + maxLen);
    }


}
