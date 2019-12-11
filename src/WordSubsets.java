import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets {
    //TL
//    public List<String> wordSubsets(String[] A, String[] B) {
//        ArrayList<HashMap> listB=new ArrayList<>();
////        HashMap<Character,Integer> maxHashB=new HashMap<>();
//        for(int i=0;i<B.length;i++){
//            HashMap<Character,Integer> hashB=new HashMap<>();
//            for(int j=0;j<B[i].length();j++) {
//                Character temp = B[i].charAt(j);
//                hashB.put(temp, hashB.getOrDefault(temp, 0) + 1);
//            }
//            listB.add(hashB);
//        }
//
//        ArrayList<String> result=new ArrayList<>();
//
//        for(int i=0;i<A.length;i++){
//            if(helper(A[i],listB)){
//                result.add(A[i]);
//            }
//        }
//
//        return result;
//
//
//    }
//
//    private boolean helper(String a,ArrayList<HashMap> listB){
//        System.out.println(a);
//        HashMap<Character,Integer> hashA=new HashMap<>();
//        for(int j=0;j<a.length();j++) {
//            Character temp = a.charAt(j);
//            hashA.put(temp, hashA.getOrDefault(temp, 0) + 1);
//        }
//
//        for(int j=0;j<listB.size();j++) {
//            HashMap<Character,Integer> hashB=listB.get(j);
//            for (Map.Entry<Character, Integer> entry : hashB.entrySet()) {
//                Character key=entry.getKey();
//                if(!hashA.containsKey(key)){
//                    return false;
//                }else{
//                    if(hashA.get(key)<hashB.get(key)){
//                        return false;
//                    }
//                }
//            }
//        }
//
//        return true;
//
//
//
//    }


    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bmax = count("");
        for (String b: B) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        List<String> ans = new ArrayList();
        search: for (String a: A) {
            int[] aCount = count(a);
            for (int i = 0; i < 26; ++i)
                if (aCount[i] < bmax[i])
                    continue search;
            ans.add(a);
        }

        return ans;
    }

    public int[] count(String S) {
        int[] ans = new int[26];
        for (char c: S.toCharArray())
            ans[c - 'a']++;
        return ans;
    }



}
