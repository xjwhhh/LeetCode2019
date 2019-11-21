package lesson.four;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String numArray=scan.nextLine();
            String[] str=scan.nextLine().split(" ");
            ArrayList<Integer> array=trans(str);
            helper(array);

        }
    }

    private static void helper(ArrayList<Integer> array){
        array.sort(Collections.reverseOrder());
        int result=0;
        while(!array.isEmpty()){
            int A=array.get(0);
            array.remove(0);
//            System.out.println(A);
            result+=A;
            if(array.contains(A-1)){
//                System.out.println("ppp"+(A-1));
                int index=array.indexOf(A-1);
//                result+=(A-1);
                array.remove(index);
            }
        }

        System.out.println(result);
    }

    private static ArrayList<Integer> trans(String[] array){
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<array.length;i++){
//            System.out.println("tt"+array[i]);
            result.add(Integer.parseInt(array[i]));
        }
        return result;
    }
}
