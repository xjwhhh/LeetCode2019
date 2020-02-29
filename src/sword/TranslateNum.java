package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-29 16:22
 * @Email xjwhhh233@outlook.com
 */
public class TranslateNum {
    public  int translateNum(int num) {
        String str=String.valueOf(num);
        int len=str.length();
        int [] dp=new  int[len+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=len;i++){
            if(compare(num,i)){
                dp[i]=dp[i-1]+dp[i-2];
            }else{
                dp[i]=dp[i-1];
            }
        }
        return dp[dp.length-1];


    }

    private boolean compare(int num,int i){
        String temp=String.valueOf(num);
        int left=Integer.parseInt(String.valueOf(temp.charAt(i-2)));
        int right=Integer.parseInt(String.valueOf(temp.charAt(i-1)));
        return left>0&&left*10+right<=25;
    }

//    public static  void main(String[] args){
//        translateNum(18580);
//    }
}
