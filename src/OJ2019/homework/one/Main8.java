package OJ2019.homework.one;

import java.util.Scanner;

class Main8 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int cas = Integer.parseInt(scanner.nextLine());
        while (cas> 0) {
            int res= 0;
            String[] arrFirstS = scanner.nextLine().split(" ");
            String[] arrSecondS = scanner.nextLine().split(" ");
            int[] arrFirst = new int[arrFirstS.length];
            int[] arrSecond = new int[arrSecondS.length];
            int[] all = new  int[2*arrFirst.length];
            int sum =0;
            for(int i =0;i<arrFirst.length;i++){
                arrFirst[i] = Integer.parseInt(arrFirstS[i]);
                arrSecond[i] = Integer.parseInt(arrSecondS[i]);
                all[i] = arrFirst[i];
                all[i+arrFirst.length] = arrSecond[i];
                sum=sum+arrFirst[i]+arrSecond[i];
            }
            exchange(all,sum,arrFirst.length);
            cas--;
        }
    }
    public  static void exchange(int[] all,int sum,int len){
        boolean[][] dp = new boolean[all.length/2+1][sum/2+1];
        dp[0][0] = true;
        //外阶段i表示第i个数，内阶段j表示选取数的个数
        for(int i = 1;i <= 2*len;++i)//外阶段i
        {
            for(int j = Math.min(i,len);j >=1;--j)//内阶段j
            {
                for(int s = 1;s <= sum/2;++s)//S(k)的所有可能取值s
                {
                    if((s >= all[i-1]) && dp[j-1][s-all[i-1]])//j个数中是否包含第i个数
                    {
                        dp[j][s]=true;

                    }
                }
            }
        }
        int s = sum/2;
        for(;s>=1 && !dp[len][s];s--){

        }
        System.out.println(sum-2*s);
    }


}
