package OJ2019.homework.three;

import java.util.*;

public class Main8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            int arrayNum = Integer.parseInt(scan.nextLine());
            String str = scan.nextLine();
            String[] array=str.split(" ");
            helper(array,arrayNum);
        }
    }

    private static void helper(String[] array,int num){
        HashMap<String,Integer> hashMap=new HashMap<>();
        for (String s : array) {
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }
        HashMap<Integer,List<Integer>> hashMap1=new HashMap<>();
        ArrayList<Integer> keys=new ArrayList<>();
        for(Map.Entry<String,Integer> entry:hashMap.entrySet()){
            String key=entry.getKey();
//            System.out.println(key);

            int value=entry.getValue();
//            System.out.println(value);
            if(hashMap1.containsKey(value)){
                List<Integer> list=hashMap1.get(value);
                list.add(Integer.parseInt(key));
                hashMap1.put(value,list);
            }else{
                List<Integer> list=new ArrayList<>();
                list.add(Integer.parseInt(key));
                hashMap1.put(value,list);
                keys.add(value);

            }
        }
        keys.sort(Collections.reverseOrder());
        StringBuilder res=new StringBuilder();
        for(int i=0;i<keys.size();i++){
            int key=keys.get(i);
//            System.out.println("tt"+key);
            List<Integer> list=hashMap1.get(key);
            Collections.sort(list);
            for(int j=0;j<list.size();j++){
                int t=list.get(j);
//                System.out.println("yyy"+t);
                for(int k=0;k<key;k++){
                    res.append(t).append(" ");
                }
            }
        }
        res.deleteCharAt(res.length()-1);
        System.out.println(res);


    }

}
