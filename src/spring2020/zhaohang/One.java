package spring2020.zhaohang;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-27 19:19
 * @Email xjwhhh233@outlook.com
 */
public class One {

    private static int T;
    private static ArrayList<Integer> arrayList=new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T=Integer.parseInt(scanner.nextLine());
        for(int j=0;j<T;j++) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] num = scanner.nextLine().split(" ");
            arrayList.clear();
            for (int i = 0; i < num.length; i++) {
                arrayList.add(Integer.parseInt(num[i]));
            }
            helper(arrayList);
        }


    }

    private static void helper(ArrayList<Integer> arrayList){
        int count=0;
        int count2=0;
        for(int i=0;i<arrayList.size();i++){
            if(arrayList.get(i)>0){
                count++;
            }
            if(arrayList.get(i)>=2){
                count2++;
            }
        }
        if(count==0||count2==0){
            System.out.println(-1);
        }else{
            System.out.println(count+1);
        }
    }
}
