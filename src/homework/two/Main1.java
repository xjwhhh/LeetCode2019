package homework.two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String str1=scan.nextLine();
            String str2=scan.nextLine();
            helper(str1,str2);
        }
    }

    private static void helper(String text1, String text2){
        int length1=text1.length();
        int length2=text2.length();
        String[][] dp1=new String[length1+1][length2+1];
        int [][] dp=new int[length1+1][length2+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    StringBuilder temp= new StringBuilder((String) dp1[i - 1][j - 1]);
                    temp.append(text1.charAt(i - 1));
                    dp1[i][j]=temp.toString();
                }
                else {
                    if (dp[i][j - 1]>dp[i - 1][j]){
                        dp[i][j]=dp[i][j - 1];
                        dp1[i][j]=dp1[i][j - 1];
                    }else{
                        dp[i][j]=dp[i-1][j];
                        dp1[i][j]=dp1[i-1][j - 1];
                    }
                }
            }
        }
//        return dp[length1][length2];
        int max=dp[length1][length2];
        if(max==0){
            return;
        }
        HashSet<String> result=new HashSet<>();
        for(int i=0;i<dp.length;i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(dp[i][j]==max){
                    result.add(dp1[i][j]);
                }
            }
        }

//        Collections.sort(result);




    }
}
