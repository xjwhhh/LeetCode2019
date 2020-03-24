import java.util.List;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-19 17:25
 * @Email xjwhhh233@outlook.com
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null||s.length()==0){
            return false;
        }
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}
