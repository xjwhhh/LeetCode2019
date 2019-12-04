package OJ2019.homework.two;

import java.util.*;
import java.util.stream.Collectors;

// wrong
public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String str1 = scan.nextLine();
            String str2 = scan.nextLine();
            helper(str1, str2);
        }
    }

    private static void helper(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        List[][] dp1=new ArrayList[length1+1][length2+1];

        for(int i=0;i<dp1.length;i++){
            for(int j=0;j<dp1[0].length;j++){
                ArrayList<String> temp=new ArrayList<>();
                temp.add("");
                dp1[i][j]=temp;
            }
        }
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    ArrayList<String> temp1=new ArrayList<>();
                    ArrayList<String> temp2=new ArrayList<>(dp1[i-1][j-1]);
                    for(String s:temp2){
                        temp1.add(s + text1.charAt(i - 1));
                    }
                    dp1[i][j]=temp1;
                } else {
                    if (dp[i][j - 1] > dp[i - 1][j]) {
                        dp[i][j] = dp[i][j - 1];
                        dp1[i][j] = dp1[i][j - 1];
                    } else if(dp[i][j - 1] < dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][j];
                        dp1[i][j] = dp1[i - 1][j];
                    }
                    else{
                        ArrayList<String> temp1=new ArrayList<>(dp1[i-1][j]);
                        ArrayList<String> temp2=new ArrayList<>(dp1[i][j-1]);
                        ArrayList<String> result=new ArrayList<>();
                        for(int k=0;k<temp1.size();k++){
                            if(!result.contains(temp1.get(k))){
                                result.add(temp1.get(k));
                            }
                        }
                        for(int k=0;k<temp2.size();k++){
                            if(!result.contains(temp2.get(k))){
                                result.add(temp2.get(k));
                            }
                        }
                        dp1[i][j]=result;
                    }
                }
            }
        }

        List<String> results =((ArrayList<String>) dp1[length1][length2]).stream()
                .filter(s -> !s.isEmpty())
                .sorted()
                .collect(Collectors.toList());
        for (String res : results) {
            System.out.println(res);
        }
    }
}
