import java.util.ArrayList;
import java.util.HashMap;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> hashMap=new HashMap<>();
        for(int i=0;i<list1.length;i++){
            hashMap.put(list1[i],i);
        }
        ArrayList<String> result=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<list2.length;i++){
            if(hashMap.containsKey(list2[i])){
                int temp=hashMap.get(list2[i])+i;
                if(temp<min){
                    result.clear();
                    result.add(list2[i]);
                    min=temp;
                }else if(temp==min){
                    result.add(list2[i]);
                }
            }

        }
        return (String[])result.toArray(new String[result.size()]);



    }
}
