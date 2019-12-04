package OJ2019.homework.one;


import java.util.ArrayList;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        for (int i = 0; i < num; i++) {
            scan.nextLine();
            String arrayString=scan.nextLine();
            String[] array=arrayString.split(" ");
//            System.out.println(arrayString);
            int sum=scan.nextInt();
//            System.out.println(sum);
            ArrayList<Integer> arrayList=new ArrayList<>();
            for(int j=0;j<array.length;j++){
                arrayList.add(Integer.parseInt(array[j]));
            }
            helper(arrayList,sum);

        }
    }

    private static void helper(ArrayList<Integer> arrayList,int sum){
        int count=0;

        for(int i=0;i<arrayList.size();i++){
            if(arrayList.contains(sum-arrayList.get(i))){
//                System.out.println(arrayList.get(i)+","+(sum-arrayList.get(i)));
                count++;
            }
        }
        System.out.println(count/2);

    }

}
