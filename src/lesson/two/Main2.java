package lesson.two;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num_of_test_case=scan.nextInt();
        for(int i=0;i<num_of_test_case;i++){
            int num_of_array=scan.nextInt();
            ArrayList<Integer> array= new ArrayList<>();
            for(int j=0;j<num_of_array;j++){
                array.add(scan.nextInt());
            }
            System.out.println(swap(array));

        }
    }


    private static int swap(ArrayList<Integer> array){

        int size=array.size();
        List<Integer> sortArray=new ArrayList<>(array);
        Collections.sort(sortArray);
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for(int i=0;i<size;i++){
            hashMap.put(sortArray.get(i),i);

        }
        int ans=0;
        int[] flags=new int[size];
        for(int i=0;i<size;i++){
            if(array.get(i).equals(sortArray.get(i))||flags[i]==1){
                continue;
            }

            int current=array.get(i);
            int right=hashMap.get(current);
            array.set(i,array.get(right));
            array.set(right,current);
            flags[right]=1;
            ans++;
            i--;
        }
        return ans;


    }

}
