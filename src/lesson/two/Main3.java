package lesson.two;

import java.util.*;


public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num_of_test_case = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num_of_test_case; i++) {
            int num_of_array=scan.nextInt();
            List<Integer> array=new ArrayList<>();
            for(int j=0;j<num_of_array;j++){
                array.add(scan.nextInt());
            }
            System.out.println(helper(array));

        }
    }

    private static int helper(List<Integer> array){
        int result=0;
        for(int i=0;i<array.size();i++){
            int temp1=array.get(i);
            for(int j=i+1;j<array.size();j++){
                if(temp1>array.get(j)){
                    result++;
                }
            }
        }

        return result;


    }
}
