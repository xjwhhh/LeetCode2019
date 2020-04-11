package golden;

/**
 * @Author JiaWei Xu
 * @Date 2020-04-11 19:36
 * @Email xjwhhh233@outlook.com
 */
public class StringToURL {
    public String replaceSpaces(String S, int length) {
        StringBuilder stringBuilder=new StringBuilder();
        char[] chars=S.toCharArray();
        for(int i=0;i<length;i++){
            char c=chars[i];
            if(c==' '){
                stringBuilder.append("%20");
            }else{
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
