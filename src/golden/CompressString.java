package golden;

/**
 * @Author JiaWei Xu
 * @Date 2020-04-11 19:55
 * @Email xjwhhh233@outlook.com
 */
public class CompressString {
    public String compressString(String S) {
        if(S==null||S.length()<=1){
            return S;
        }
        char[] chars=S.toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        char c=chars[0];
        int count=1;
        for(int i=1;i<chars.length;i++){
            if(chars[i]==c){
                count++;
                if(i==chars.length-1){
                    stringBuilder.append(c).append(count);
                }
            }else{
                stringBuilder.append(c).append(count);
                c=chars[i];
                count=1;
            }
        }

        if(stringBuilder.length()<S.length()){
            return stringBuilder.toString();
        }else{
            return S;
        }

    }

    //滑动窗口
    public String compressString1(String S) {
        int N = S.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < N) {
            int j = i;
            while (j < N && S.charAt(j) == S.charAt(i)) {
                j++;
            }
            sb.append(S.charAt(i));
            sb.append(j - i);
            i = j;
        }

        String res = sb.toString();
        if (res.length() < S.length()) {
            return res;
        } else {
            return S;
        }
    }

}
