package OJ2019.homework.reviewer;

import java.util.ArrayList;
import java.util.Scanner;

public class str_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<total;i++){
            String[] str=scanner.nextLine().split(",");
            String A=str[0];
            String B=str[1];
            helper(A,B);
        }
    }

    private static void helper(String A,String B){
        int lenA=A.length();
        int lenB=B.length();
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<=lenA-lenB;i++){
            boolean flag=true;
            for(int j=0;j<lenB;j++){
                if(A.charAt(i+j)!=B.charAt(j)){
                    flag=false;
                    break;
                }

            }
            if(flag){
                result.add(i);
            }

        }
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<result.size();i++){
            stringBuilder.append(result.get(i)).append(" ");
        }
        if(stringBuilder.length()>=1) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            System.out.println(stringBuilder);
        }else{
            System.out.println(-1);
        }

    }
}
