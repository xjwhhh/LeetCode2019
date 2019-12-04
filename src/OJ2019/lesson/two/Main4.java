package OJ2019.lesson.two;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num_of_test_case = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num_of_test_case; i++) {
            String[] nums = scan.nextLine().split(" ");
            int num_of_one = Integer.parseInt(nums[0]);
            if(num_of_one==0){
                System.out.println();
                continue;
            }
            int num_of_two = Integer.parseInt(nums[1]);
            String[] one = scan.nextLine().split(" ");
            String[] two = scan.nextLine().split(" ");
            TreeMap<Integer, Integer> treeMap_one_one = new TreeMap<>();
            TreeMap<Integer, Integer> treeMap_one_two = new TreeMap<>();
            ArrayList<Integer> list_two = new ArrayList<>();
            for (int j = 0; j < two.length; j++) {
                int key = Integer.parseInt(two[j]);
                if(!list_two.contains(key)){
                    list_two.add(key);
                }
            }

            for (int j = 0; j < one.length; j++) {
                int key = Integer.parseInt(one[j]);
                if (list_two.contains(key)) {
                    treeMap_one_one.put(key, treeMap_one_one.getOrDefault(key, 0) + 1);
                } else {
                    treeMap_one_two.put(key, treeMap_one_two.getOrDefault(key, 0) + 1);
                }
            }

            StringBuilder builder = new StringBuilder();

            for (int j = 0; j < list_two.size(); j++) {
                int key = list_two.get(j);
                if (treeMap_one_one.containsKey(key)) {
                    for (int k = 0; k < treeMap_one_one.get(key); k++) {
                        builder.append(key+" ");
                    }
                }
            }

            for (Integer key:treeMap_one_two.keySet()) {
                int num=treeMap_one_two.get(key);
                for(int j=0;j<num;j++){
                    builder.append(key+" ");
                }
            }


            String  reS = builder.toString();
            if (reS.isEmpty()) {
                System.out.println();
            } else {
                System.out.println(reS.substring(0, reS.length() - 1));
            }



        }
    }
}
