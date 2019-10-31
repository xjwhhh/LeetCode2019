package lesson.three;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String str1=scan.nextLine();
            String[] array=str1.split(",");
            ArrayList<Integer> result=helper(array);
            print(result);
        }
    }

    private static ArrayList<Integer> helper(String[] array){
        String txt=array[0];
        String pattern=array[1];
        int fromIndex=0;
        ArrayList<Integer> result=new ArrayList<>();
        while(fromIndex<txt.length()&&txt.indexOf(pattern,fromIndex)!=-1){
//            System.out.println(fromIndex);

            int temp=txt.indexOf(pattern,fromIndex);
//            if(!result.contains(temp)) {
//                result.add(temp);
//            }
//            System.out.println(temp);
            result.add(temp);
            fromIndex=temp+1;
        }
        return result;
    }

    private static void print(ArrayList<Integer> array){
        StringBuilder res=new StringBuilder();
        for(int j=0;j<array.size()-1;j++){
            res.append(array.get(j));
            res.append(" ");
        }
        if(array.size()-1>=0) {
            res.append(array.get(array.size() - 1));
        }
        System.out.println(res);
    }
}
