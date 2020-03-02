package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-02 10:41
 * @Email xjwhhh233@outlook.com
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if(s==null||s.trim().equals("")){
            return "";
        }
        String[] array=s.split(" ");
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=array.length-1;i>=0;i--){
            if(!array[i].trim().equals("")){
                stringBuilder.append(array[i].trim()).append(" ");
            }
        }
        if(stringBuilder.length()>0) {
            return stringBuilder.substring(0, stringBuilder.length() - 1);
        }else{
            return "";
        }
    }
}
