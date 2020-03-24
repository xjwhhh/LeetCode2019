package spring2020.kuaishoubishi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-22 18:57
 * @Email xjwhhh233@outlook.com
 */
public class Two {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        ArrayList<Integer> arrayList=new ArrayList<>();
        String str=scanner.nextLine();
        String[] array=str.split(" ");
        for(int i=0;i<array.length;i++){
            arrayList.add(Integer.valueOf(array[i]));
        }
        helper(arrayList);
    }

    private static void helper(ArrayList<Integer> arrayList){
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=1;i<arrayList.size();i++){
            int count=0;
            for(int j=0;j<i;j++){
                if(arrayList.get(j)>arrayList.get(i)){
                    count++;
                }
            }
            if(count==1){
                result.add(i);
            }
        }
        if(result.size()==0){
            System.out.println(-1);
        }else{
            StringBuilder stringBuilder=new StringBuilder();
            for(int i=0;i<result.size();i++){
                stringBuilder.append(result.get(i)).append(" ");
            }
            System.out.println(stringBuilder.substring(0,stringBuilder.length()-1));
        }
    }
}
