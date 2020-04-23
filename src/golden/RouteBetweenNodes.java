package golden;

import sword.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Author JiaWei Xu
 * @Date 2020-04-23 14:15
 * @Email xjwhhh233@outlook.com
 */
public class RouteBetweenNodes {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        HashSet<Integer> hashSet=new HashSet<>();
        HashMap<Integer, List<Integer>> hashMap=new HashMap<>();

        for(int i=0;i<graph.length;i++){
            int s=graph[i][0];
            int e=graph[i][1];
            if(hashMap.containsKey(s)){
                hashMap.get(s).add(e);
            }else{
                List<Integer> list=new ArrayList<>();
                list.add(e);
                hashMap.put(s,list);
            }
//            if(hashMap.containsKey(e)){
//                hashMap.get(e).add(s);
//            }else{
//                List<Integer> list=new ArrayList<>();
//                list.add(s);
//                hashMap.put(e,list);
//            }
        }

        List<Integer> curr=new ArrayList<>();
        curr.add(start);
        while(true) {
            boolean haveNew=false;
            List<Integer> next=new ArrayList<>();
            for (Integer i : curr) {
                List<Integer> list=hashMap.get(i);
                for(Integer j:list){
                    if(j==target){
                        return true;
                    }else{
                        if(!hashSet.contains(j)){
                            hashSet.add(j);
                            next.add(j);
                            haveNew=true;
                        }
                    }
                }
            }
            if(!haveNew){
                return false;
            }
            curr=next;
        }

    }
}
