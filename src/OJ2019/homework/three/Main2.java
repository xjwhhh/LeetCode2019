package OJ2019.homework.three;

import java.util.Scanner;

public class Main2 {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            int cas = Integer.parseInt(scanner.nextLine());
            while (cas>0){
                String[] fl = scanner.nextLine().split(",");
                double[][]  arr = new double[fl.length][2];
                double[] x = new double[fl.length];
                double[] y = new double[fl.length];
                for(int i =0;i<arr.length;i++){
                    arr[i][0] = Integer.parseInt(fl[0]);
                    arr[i][1] = Integer.parseInt(fl[1]);
                }


            }
        }
    public static double Variance(double[] x) {
               int m=x.length;
                 double sum=0;
                 for(int i=0;i<m;i++){//求和
                         sum+=x[i];
                    }
                 double dAve=sum/m;//求平均值
                 double dVar=0;
                 for(int i=0;i<m;i++){//求方差
                         dVar+=(x[i]-dAve)*(x[i]-dAve);
                     }
                 return dVar/m;
             }
}
