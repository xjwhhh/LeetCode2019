package lesson.two;


import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num_of_test_case = scan.nextInt();
        for (int i = 0; i < num_of_test_case; i++) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int num_of_array = scan.nextInt();
            for (int j = 0; j < num_of_array; j++) {
                int num = scan.nextInt();
                hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            }
            helper(hashMap);
        }


    }

    private static void helper(HashMap<Integer,Integer> hashMap ){
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            //升序排序
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {

                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }

        });

        StringBuilder builder = new StringBuilder();

//        ArrayList<Integer> result=new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            int key=list.get(i).getKey();
            int num=list.get(i).getValue();
            for(int j=0;j<num;j++){
//                result.add(key);
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
